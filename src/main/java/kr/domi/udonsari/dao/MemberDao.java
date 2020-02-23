package kr.domi.udonsari.dao;

import kr.domi.udonsari.model.MemberSignUpReq;
import kr.domi.udonsari.vo.MemberVO;

import java.util.HashMap;

public interface MemberDao {
    MemberVO checkId(String uid);
    boolean register(MemberSignUpReq memberSignUpReq);
}
