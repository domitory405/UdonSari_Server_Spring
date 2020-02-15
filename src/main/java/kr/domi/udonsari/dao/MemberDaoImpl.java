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
    public int register(HashMap<String, Object> map) {
        /*
        * insert 결과
        * 0 : fail
        * 1 : success
        * */
        int result = 0;

        try {
            System.out.println(map);
            result = sqlSession.insert("kr.domi.udonsari.MemberMapper.insertMember", map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}