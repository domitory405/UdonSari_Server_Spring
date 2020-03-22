package kr.domi.udonsari.controller;

import kr.domi.udonsari.service.MatchingService;
import kr.domi.udonsari.vo.MatchingVO;

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
@RequestMapping(value="/sari/matching")
public class MatchingController {

@Autowired
private MatchingService matchingService;
private JwtService jwtService;  // token

/*
 * 유저의 매칭정보 조회
 * param matchingVO
 * return Exception
 * */

@GetMapping("/")
public ResponseEntity getMathchedUser
        (@RequestHeader(value = "Authorization", required = false) final String header) {
        try {
            if(matchedList == null){   // 매칭이 존재하지 않을 경우
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST, "매칭정보가 존재하지 않습니다");
            }
                return new ResponseEntity<>(HttpStatus.OK, "유저 매칭정보 조회 성공", matchedList);
        } catch (Exception e) {
            log.error(e.getMessage());
                return new ResponseEntity<>(FAIL_INTERNAL_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }