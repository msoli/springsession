package com.example.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/close")
    public String close() {
        return "close";
    }

    @GetMapping("/secure")
    public String secure() {
        return "secure";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


}
