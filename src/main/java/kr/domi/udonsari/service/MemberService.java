package kr.domi.udonsari.service;

import kr.domi.udonsari.model.DefaultRes;
import kr.domi.udonsari.model.MemberSignUpReq;

public interface MemberService {
    DefaultRes signUp(MemberSignUpReq memberSignUpReq);
}
