package kr.domi.udonsari.dao;

import kr.domi.udonsari.vo.MemberVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.HashMap;

@Repository
public class MemberDaoImpl implements MemberDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public int checkId(HashMap<String, Object> map) {
        /*
         * return
         * 0 : fail
         * 1 : success
         * */
        int count  = sqlSession.selectOne("kr.domi.udonsari.MemberMapper.countMember", map.get("uid").toString());

        if(count == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public void register(HashMap<String, Object> map) {
        try {
            sqlSession.insert("kr.domi.udonsari.MemberMapper.insertMember", map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}