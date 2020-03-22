package kr.domi.udonsari.controller;

import kr.domi.udonsari.service.ProfileService;
import kr.domi.udonsari.vo.ProfileVO;

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
@RequestMapping(value="/sari/profle")
public class ProfileController {

    @Autowired
    private ProfileService profileService;
    private JwtService jwtService;  // token

    /*
     * 선택된 유저의 프로필 조회
     * param ProfileVO
     * return Exception
     * */

    @GetMapping("/:userIdx")
    public ResponseEntity getProfileUser (@PathVariable final int userIdx)  {
        try {
            // path가 null일 경우

            if(userIdx == null){   // 유저가 존재하지 않을 경우
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST, "유저가 존재하지 않습니다");
            }
            return new ResponseEntity<>(HttpStatus.OK, "유저 프로필 조회 성공", profileInfo);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(FAIL_INTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }