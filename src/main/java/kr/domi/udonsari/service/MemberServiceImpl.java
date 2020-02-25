package kr.domi.udonsari.service;

import kr.domi.udonsari.dao.MemberDao;
import kr.domi.udonsari.dto.MemberDto;
import kr.domi.udonsari.model.DefaultRes;
import kr.domi.udonsari.model.MemberSignInReq;
import kr.domi.udonsari.model.MemberSignUpReq;
import kr.domi.udonsari.utils.ResponseMessage;
import kr.domi.udonsari.utils.SHA256PasswordEncoder;
import kr.domi.udonsari.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static kr.domi.udonsari.utils.SHA256PasswordEncoder.*;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public DefaultRes signUp(MemberSignUpReq memberSignUpReq) {
        //중복된 id 존재 여부
        if(memberDao.checkId(memberSignUpReq.getUid()) == 0) {
            /* salt 생성 -> 암호화 -> memberSignUpReq에 set.. */
            final String salt =  generateSalt();
            memberSignUpReq.setSalt(salt);
            memberSignUpReq.setPwd(encrypt(memberSignUpReq.getPwd().toString(), salt.getBytes()));

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

    @Override
    public DefaultRes signIn (MemberSignInReq memberSignInReq) {
        final String salt = memberDao.getSalt(memberSignInReq.getUid());
        final String hashPwd = SHA256PasswordEncoder.encrypt(memberSignInReq.getPwd(), salt.getBytes());
        memberSignInReq.setHashPwd(hashPwd);

        final MemberDto member = memberDao.signIn(memberSignInReq);

        if(member != null) {
            //jwt 발급
        } else{

        }

        return null;
    }
}
