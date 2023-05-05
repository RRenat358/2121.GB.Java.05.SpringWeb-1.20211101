package ru.rrenat358.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class DemoController {
    @GetMapping("/set")
    public String setDemo(@RequestParam String key, @RequestParam String value, HttpSession session) {
        session.setAttribute(key, value);
        return "session added: " + key + " " + value;
    }

    @GetMapping("/get")
    public String getDemo(@RequestParam String key, HttpSession session) {
        return "from session: " + session.getAttribute(key);
    }
}
