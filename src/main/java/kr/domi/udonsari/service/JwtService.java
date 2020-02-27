package kr.domi.udonsari.service;

import kr.domi.udonsari.dto.MemberDto;
import kr.domi.udonsari.model.MemberSignInReq;

public interface JwtService {
    //token 생성
    String createToken(MemberDto member);
    boolean checkToken(String token);
}
