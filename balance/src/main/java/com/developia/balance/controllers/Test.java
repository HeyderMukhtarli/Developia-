package com.developia.balance.controllers;

import com.developia.balance.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class Test {
    private final EmailService emailService;
    @GetMapping("/test")
    public String test() {
        emailService.sendHtmlEmail("heydarmuxtar@gmail.com", "OTP","Your OTP is: 123456");
        return "Email sent";
    }
}
