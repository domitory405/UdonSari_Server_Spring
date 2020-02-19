package kr.domi.udonsari.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value="/")
    public String home() {
        System.out.println("Home Controller 실행");
        return "index";
    }
}
