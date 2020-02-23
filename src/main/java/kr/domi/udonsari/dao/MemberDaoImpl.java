package kr.domi.udonsari.dao;

import kr.domi.udonsari.dto.MemberDto;
import kr.domi.udonsari.model.MemberSignUpReq;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private SqlSession sqlSession;

    /*
    * 중복된 ID 체크
    *
    * @param uid 유저 아이디
    * @return Member 객체
    * */
    @Override
    public int checkId(String uid) {
        int count = sqlSession.selectOne("kr.domi.udonsari.MemberMapper.countMember", uid);
        return count;
    }

    /*
    *  회원 가입
    *S
    * @param
    * @return boolean - True 성공
    * */
    @Override
    public boolean register(MemberSignUpReq memberSignUpReq) {
        try {
            sqlSession.insert("kr.domi.udonsari.MemberMapper.insertMember", memberSignUpReq);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}