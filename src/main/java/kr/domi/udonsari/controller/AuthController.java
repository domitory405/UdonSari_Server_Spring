package kr.domi.udonsari.controller;

import kr.domi.udonsari.model.MemberSignInReq;
import kr.domi.udonsari.model.MemberSignUpReq;
import kr.domi.udonsari.service.MemberService;
import kr.domi.udonsari.utils.SHA256PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static kr.domi.udonsari.model.DefaultRes.FAIL_DEFAULT_RES;

@RestController
@RequestMapping(value="/auth")
public class AuthController {
    @Autowired
    private MemberService memberService;

    @GetMapping(value="/test")
    public String test() {
        return "Auth Controller Test";
    }

    /*
    * 회원가입
    * @Req memberSignUpReq
    * @return
    * */
    @PostMapping(value="/signup")
    public ResponseEntity signup(@RequestBody MemberSignUpReq memberSignUpReq) {
        System.out.println(memberSignUpReq.getUid());
        try {
            return new ResponseEntity<>(memberService.signUp(memberSignUpReq), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
    * 로그인
    * @Req MemberLoginReq
    * @return
    * */
    @PostMapping(value="signin")
    public void signin(@RequestBody final MemberSignInReq memberSignInReq) {
        try {
            String salt="";
            String hashPwd = SHA256PasswordEncoder.encrypt(memberSignInReq.getPwd(), salt.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}