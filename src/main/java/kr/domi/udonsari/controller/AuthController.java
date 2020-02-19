package kr.domi.udonsari.controller;

import kr.domi.udonsari.service.MemberService;
import kr.domi.udonsari.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="/auth")
public class AuthController {
    @Autowired
    private MemberService memberService;

    @GetMapping(value="/test")
    public String test() {
        return "Auth Controller Test";
    }

    @PostMapping(value="/signup")
    public String signup(@RequestBody HashMap<String, Object> map) {
        memberService.signUp(map);

        return "Signin Success";
    }
}