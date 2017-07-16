package com.github.user.service;

import com.github.user.api.AccountApi;
import com.github.user.api.bean.account.*;
import com.github.user.api.core.LogTypes;
import com.github.user.api.exception.UserApiException;
import com.github.user.service.entity.*;
import com.github.user.service.repository.*;
import com.github.user.service.stream.message.UserLogMessage;
import com.github.user.service.stream.producer.UserLogProducer;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class AccountService implements AccountApi {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserLoginRepository userLoginRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private UserLogProducer userLogProducer;

    @Override
    public LoginResult login(@Validated @RequestBody LoginReq req) throws UserApiException {
        Account account = accountRepository.getByUsername(req.getUsername());
        if (account == null) {
            throw new UserApiException(UserApiException.INVALID_USERNAME, "用户名" + req.getUsername() + "不存在");
        }
        if (!account.getPassword().equals(DigestUtils.sha512Hex(req.getPassword()))) {
            throw new UserApiException(UserApiException.WRONG_PASSWORD, "密码错误");
        }

        User user = userRepository.getByUserId(account.getUserId());
        if (user == null) {
            throw new UserApiException(UserApiException.INVALID_USER_ID, "用户id" + account.getUserId() + "不存在");
        }

        List<UserGroup> userGroups = userGroupRepository.listByUserId(user.getUserId());

        List<Permission> permissions = permissionRepository.listByUserId(user.getUserId());
        permissions.addAll(permissionRepository.listByGroupIds(userGroups.stream().map(UserGroup::getGroupId).collect(Collectors.toList())));

        Date now = new Date();

        UserLogin userLogin = new UserLogin();
        userLogin.setAccessToken(UUID.randomUUID().toString());
        userLogin.setClientId(req.getClientId());
        userLogin.setClientVersion(req.getClientVersion());
        userLogin.setUserId(user.getUserId());
        userLogin.setLoginDate(now);
        permissions.stream().map(Permission::getPermissionCode).reduce((p1, p2) -> p1 | p2)
                .ifPresent(userLogin::setPermissionCode);

        account.setLastLoginDate(now);
        accountRepository.update(account);

        userLoginRepository.create(userLogin);

        UserLogMessage userLogMessage = new UserLogMessage();
        userLogMessage.setLogDate(now);
        userLogMessage.setLogId(UUID.randomUUID().toString());
        userLogMessage.setLogMessage("用户" + account.getUsername() + "登录");
        userLogMessage.setLogType(LogTypes.LOGIN);
        userLogMessage.setUserId(user.getUserId());
        userLogProducer.produce(userLogMessage);

        LoginResult result = new LoginResult();
        result.setAccessToken(userLogin.getAccessToken());
        result.setUserId(user.getUserId());
        result.setName(user.getName());
        return result;
    }

    @Override
    public LogoutResult logout(@Validated @RequestBody LogoutReq req) throws UserApiException {
        userLoginRepository.deleteByAccessToken(req.getAccessToken());
        Date now = new Date();
        LogoutResult result = new LogoutResult();
        result.setLogoutDate(now);
        return result;
    }

    @Override
    public ValidateResult validate(@Validated @RequestBody ValidateReq req) throws UserApiException {
        UserLogin userLogin = userLoginRepository.getByAccessToken(req.getAccessToken());
        if (userLogin == null) {
            throw new UserApiException(UserApiException.INVALID_ACCESS_TOKEN, "访问令牌无效");
        }
        ValidateResult result = new ValidateResult();
        result.setUserId(userLogin.getUserId());
        result.setName(userLogin.getName());
        result.setPermissionCode(userLogin.getPermissionCode());
        return result;
    }
}
