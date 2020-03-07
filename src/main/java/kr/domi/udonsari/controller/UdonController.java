package kr.domi.udonsari.controller;

import kr.domi.udonsari.dto.MemberDto;
import kr.domi.udonsari.service.MemberService;
import kr.domi.udonsari.service.UdonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.FailedLoginException;
import java.util.HashMap;

import static kr.domi.udonsari.model.DefaultRes.FAIL_DEFAULT_RES;

@RestController
@RequestMapping(value = "udon")
public class UdonController {

    @Autowired
    UdonService udonService;

    @Autowired
    MemberService memberService;

    @GetMapping(value = "/")
    public ResponseEntity CheckRegion(@RequestBody final HashMap<String, String> map) {

        //idx로 Member객체 가져오기
        MemberDto member = memberService.getMember(map.get("idx"));
        //param으로 들어온 gps의 법정동 코드
        String regCode = udonService.getRegCode(map.get("gps"));

        if (member != null && regCode != null) {
            try {
                System.out.println("params : " + map.get("idx"));
                return new ResponseEntity<>(udonService.checkReg(member, regCode), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(FAIL_DEFAULT_RES, HttpStatus.UNAUTHORIZED);
        }

    }
}
