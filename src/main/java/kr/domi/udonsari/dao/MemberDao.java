package kr.domi.udonsari.dao;

import kr.domi.udonsari.dto.MemberDto;
import kr.domi.udonsari.model.MemberSignInReq;
import kr.domi.udonsari.model.MemberSignUpReq;

public interface MemberDao {
    int checkId(String uid);
    boolean register(MemberSignUpReq memberSignUpReq);
    String getSalt(String uid);
    MemberDto signIn(MemberSignInReq memberSignInReq);
    MemberDto getMember(String idx);
}
