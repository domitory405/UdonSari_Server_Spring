package kr.domi.udonsari.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="main")
public class MainController {

    @RequestMapping(value = "/")
    public String home() {
        System.out.println("Home Controller 실행");
        return "index";
    }

    /*
    * Mode 선택
    * @Param: mode (0이면 사리, 1이면 우동모드)
    * */
    @GetMapping(value = "/{selectmode}")
    public void SelectMode(@PathVariable("selectmode") int mode) {
        switch (mode) {
            case 0:
                System.out.println("사리모드 1:1 매칭");
                break;
            case 1:
                System.out.println("우동모드 지역별 단체 채팅");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
    }
}
