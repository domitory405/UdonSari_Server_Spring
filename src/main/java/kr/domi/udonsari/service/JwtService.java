package kr.domi.udonsari.service;

import kr.domi.udonsari.dto.MemberDto;

public interface JwtService {
    //token 생성
    String createToken(MemberDto member);
}
