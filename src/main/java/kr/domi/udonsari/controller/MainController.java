package kr.domi.udonsari.controller;

import kr.domi.udonsari.model.DefaultRes;
import kr.domi.udonsari.utils.ResponseMessage;
import kr.domi.udonsari.utils.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity SelectMode(@PathVariable("selectmode") int mode) {
        switch (mode) {
            case 0:
                System.out.println("사리모드 1:1 매칭");
                return new ResponseEntity<>(DefaultRes.res(StatusCode.OK, ResponseMessage.MODE_SARI), HttpStatus.OK);
            case 1:
                System.out.println("우동모드 지역별 단체 채팅");
                return new ResponseEntity(DefaultRes.res(StatusCode.OK, ResponseMessage.MODE_UDON), HttpStatus.OK);
            default:
                System.out.println("잘못된 입력입니다.");
                return new ResponseEntity<>(DefaultRes.res(StatusCode.BAD_REQ, ResponseMessage.MODE_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
