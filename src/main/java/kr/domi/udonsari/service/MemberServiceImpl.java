package kr.domi.udonsari.service;

import kr.domi.udonsari.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public void signUp(HashMap<String, Object> map) {
        if(memberDao.checkId(map) == 0) {
            memberDao.register(map);
        } else {
            System.out.println("중복된 ID 입니다.");
        }
    }
}
