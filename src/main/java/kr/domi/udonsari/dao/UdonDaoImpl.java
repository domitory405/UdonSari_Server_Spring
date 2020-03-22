package kr.domi.udonsari.dao;

import kr.domi.udonsari.model.GpsReq;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UdonDaoImpl implements UdonDao{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void updateGps(GpsReq gpsReq) {
        sqlSession.update("kr.domi.udonsari.UdonMapper.updateGps", gpsReq);
    }
}
