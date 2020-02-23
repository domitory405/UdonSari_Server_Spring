package kr.domi.udonsari.service;

import kr.domi.udonsari.dao.MemberDao;
import kr.domi.udonsari.model.MemberSignUpReq;
import kr.domi.udonsari.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public void signUp(MemberSignUpReq memberSignUpReq) {
        //중복된 id 존재 여부
        if(memberDao.checkId(memberSignUpReq.getUid()) == null) {
            if(memberDao.register(memberSignUpReq)) {
                //res 회원가입 성공 날리기
            } else {
                //DB 오류있을 때
            }
        } else {
            //res 아이디 중복 날리기
            System.out.println("중복된 ID 입니다.");
        }
    }
}
