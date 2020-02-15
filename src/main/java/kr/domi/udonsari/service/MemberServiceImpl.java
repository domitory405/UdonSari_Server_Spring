package kr.domi.udonsari.service;

import kr.domi.udonsari.dao.MemberDao;
import kr.domi.udonsari.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public void signUp(HashMap<String, Object> map) {
        int result = memberDao.register(map);
    }
}
