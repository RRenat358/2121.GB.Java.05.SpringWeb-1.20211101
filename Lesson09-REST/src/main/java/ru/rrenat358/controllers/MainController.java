package ru.rrenat358.controllers;

import ru.rrenat358.dto.ResultDto;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @GetMapping("/calc/add")
    public ResultDto calculateAdd(@RequestParam Integer a, @RequestParam Integer b) {
        return new ResultDto(a + b);
    }
}
