package com.github.user.client;

import com.github.user.client.core.Authorize;
import org.springframework.stereotype.Controller;
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
