package kr.domi.udonsari.service;

import kr.domi.udonsari.vo.MemberVO;

import java.util.HashMap;

public interface MemberService {
    void signUp(HashMap<String, Object> map);
}
