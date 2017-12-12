package com.example.session;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @GetMapping("/")
    public String helloAdmin() {
        return "hello admin from rest controller";
    }


}
