package kr.domi.udonsari.controller;

import kr.domi.udonsari.service.SwipeService;
import kr.domi.udonsari.vo.SwipeVO;

import lombok.extern.slf4j.Slf4j;
import kr.domi.udonsari.model.DefaultRes;
import kr.domi.udonsari.ResponseMessage;
import kr.domi.udonsari.StatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value="/sari/swipe")
public class SwipeController {

    @Autowired
    private SwipeService swipeService;
    private JwtService jwtService;  // token

    /*
     * 매칭 유저 조회
     * param swipeVO
     * return Exception
     * */

    // 유저의 위치값 받아오기
   @GetMapping("/")
    public ResponseEntity getMathicngUser
        (@RequestHeader(value = "Authorization", required = false) final String header) {
        try {
            if(user_gps == null){   // 유저의 위치값이 없는 경우
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST, "유저의 위치값이 존재하지 않습니다");
        }
            return new ResponseEntity<>(HttpStatus.OK, "매칭 유저 조회 성공", matchingUserList);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_INTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
     * 매칭 판별
     * param swipeVO
     * return Exception
     * */

    @PostMapping("/")
    public ResponseEntity saveDisplay
        (@RequestHeader(value = "Authorization", required = false) final String header,
        @RequestBody final SwipeReq swipeReq) {
        try {
            if(matching_state1 == 1 && matching_state2 == 1){   // 이미 매칭 정보가 있는 상태
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST, "이미 존재하는 매칭 정보");
        }
            return new ResponseEntity<>(HttpStatus.OK, "매칭 판별 성공");
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_INTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}