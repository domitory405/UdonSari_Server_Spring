package kr.domi.udonsari.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/auth")
public class AuthController {

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String test() {
        return "Auth Controller Test";
    }
}
