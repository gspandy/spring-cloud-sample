package com.github.user.client;

import com.github.user.api.AccountApi;
import com.github.user.client.model.UserContext;
import com.github.user.api.bean.account.LoginReq;
import com.github.user.api.bean.account.LoginResult;
import com.github.user.api.bean.account.LogoutReq;
import com.github.user.client.core.Authorize;
import com.github.user.client.core.UserContextProcessor;
import com.github.user.api.exception.UserApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Controller
@RequestMapping("/account")
@Validated
public class AccountController extends ControllerBase {

    @Autowired
    private UserContextProcessor userContextProcessor;

    @Autowired
    private AccountApi accountApi;

    @GetMapping("/login")
    public void login(Model model) {
        model.addAttribute("username", "admin");
    }

    @PostMapping("/login")
    public String login(
            @NotNull @Size(min = 1) String username,
            @NotNull @Size(min = 1) String password,
            Model model,
            HttpServletRequest request,
            HttpServletResponse response) throws UserApiException {

        LoginReq loginReq = new LoginReq();
        loginReq.setUsername(username);
        loginReq.setPassword(password);
        loginReq.setClientId("web_admin");
        loginReq.setClientVersion("1.0.0");
        LoginResult loginResult = accountApi.login(loginReq);

        UserContext userContext = new UserContext();
        userContext.setAccessToken(loginResult.getAccessToken());
        userContextProcessor.initialize(userContext, request, response);

        return "redirect:/";
    }

    @RequestMapping("/logout")
    @Authorize
    public String logout(@RequestAttribute(USER_CONTEXT_KEY) UserContext userContext, HttpServletResponse response) throws UserApiException {
        LogoutReq logoutReq = new LogoutReq();
        logoutReq.setAccessToken(userContext.getAccessToken());
        accountApi.logout(logoutReq);
        userContextProcessor.destroy(userContext, response);
        return "redirect:/";
    }
}
