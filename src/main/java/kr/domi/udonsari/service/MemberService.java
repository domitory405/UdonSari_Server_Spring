package kr.domi.udonsari.service;

import kr.domi.udonsari.dto.MemberDto;
import kr.domi.udonsari.model.DefaultRes;
import kr.domi.udonsari.model.MemberSignInReq;
import kr.domi.udonsari.model.MemberSignUpReq;

public interface MemberService {
    DefaultRes signUp(MemberSignUpReq memberSignUpReq);
    DefaultRes signIn(MemberSignInReq memberSignInReq);
    MemberDto getMember(String idx);
}
