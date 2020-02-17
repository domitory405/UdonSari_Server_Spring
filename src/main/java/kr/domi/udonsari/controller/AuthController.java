package kr.domi.udonsari.controller;

import kr.domi.udonsari.service.MemberService;
import kr.domi.udonsari.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping(value="/auth")
public class AuthController {
    @Autowired
    private MemberService memberService;

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String test() {
        return "Auth Controller Test";
    }

    @RequestMapping(value="/signup", method = RequestMethod.POST)
    public String signup(@RequestBody HashMap<String, Object> map) {
        memberService.signUp(map);

        return "Signin Success";
    }
}