package com.github.user;

import com.github.user.core.Authorize;
import com.github.user.core.UserContextProcessor;
import com.github.user.model.UserContext;
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
            HttpServletResponse response) {

        boolean isCredentialValid = "admin".equals(username) && "admin123".equals(password);

        if (!isCredentialValid) {
            model.addAttribute("username", username);
            model.addAttribute("errorMessage", "登录凭据无效");
            return "/account/login";
        }

        UserContext userContext = new UserContext();
        userContextProcessor.initialize(userContext, request, response);

        return "redirect:/";
    }

    @RequestMapping("/logout")
    @Authorize
    public String logout(@RequestAttribute(USER_CONTEXT_KEY) UserContext userContext, HttpServletResponse response) {
        userContextProcessor.destroy(userContext, response);
        return "redirect:/";
    }
}
