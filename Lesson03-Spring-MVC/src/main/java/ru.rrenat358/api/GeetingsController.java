package ru.rrenat358.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GeetingsController {

    @GetMapping("/h")
    @ResponseBody
    public String helloWord() {
        return "HW!";
    }


}
