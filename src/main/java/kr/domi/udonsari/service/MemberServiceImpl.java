package kr.domi.udonsari.service;

import kr.domi.udonsari.dao.MemberDao;
import kr.domi.udonsari.model.DefaultRes;
import kr.domi.udonsari.model.MemberSignUpReq;
import kr.domi.udonsari.utils.ResponseMessage;
import kr.domi.udonsari.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public DefaultRes signUp(MemberSignUpReq memberSignUpReq) {
        //중복된 id 존재 여부
        if(memberDao.checkId(memberSignUpReq.getUid()) == 0) {
            if(memberDao.register(memberSignUpReq)) {
                //res 회원가입 성공 날리기
                return DefaultRes.res(StatusCode.OK, ResponseMessage.CREATED_USER);
            } else {
                //DB 오류있을 때
                return DefaultRes.res(StatusCode.DB_ERROR, ResponseMessage.DB_ERROR);
            }
        } else {
            //res 아이디 중복 날리기
            System.out.println("중복된 ID 입니다.");
            return DefaultRes.res(StatusCode.FORBIDDEN, ResponseMessage.ALREADY_USER);
        }
    }
}
