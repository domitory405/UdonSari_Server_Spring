package kr.domi.udonsari.dao;

import kr.domi.udonsari.vo.MemberVO;

import java.util.HashMap;

public interface MemberDao {
    int checkId(HashMap<String, Object> map);
    void register(HashMap<String, Object> map);
}
