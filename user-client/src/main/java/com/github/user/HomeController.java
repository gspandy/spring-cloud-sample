package com.github.user;

import com.github.user.core.Authorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@Authorize
public class HomeController extends ControllerBase {

    @GetMapping("")
    public String index() {
        return "/home/index";
    }
}
