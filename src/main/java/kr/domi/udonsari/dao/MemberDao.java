package kr.domi.udonsari.dao;

import kr.domi.udonsari.vo.MemberVO;

import java.util.HashMap;

public interface MemberDao {
    public int register(HashMap<String, Object> map);
}
