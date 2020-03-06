package kr.domi.udonsari.controller;

import kr.domi.udonsari.dto.MemberDto;
import kr.domi.udonsari.model.DefaultRes;
import kr.domi.udonsari.service.MemberService;
import kr.domi.udonsari.service.UdonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value="udon")
public class UdonController {

    @Autowired
    UdonService udonService;

    @Autowired
    MemberService memberService;

    @GetMapping(value="/")
    public void CheckRegion(@RequestBody final HashMap<String, String> map) {

        System.out.println("params : " + map.get("idx"));

        //idx로 Member객체 가져오기
        MemberDto member = memberService.getMember(map.get("idx"));
        //param으로 들어온 gps의 법정동 코드
        String regCode = udonService.getRegCode(map.get("gps"));
        System.out.println(regCode);

        if( regCode.equals(member.getGps()) ) {
            System.out.println("[regCode : " + regCode + ", memberGps : " + member.getGps() + "] GPS 변경 없음");
        } else {
            System.out.println("GPS 변경됨");
            //DB 값 업데이트 해주기~~
        }
    }
}
