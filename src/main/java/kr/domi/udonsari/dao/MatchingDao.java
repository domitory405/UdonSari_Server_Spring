package kr.domi.udonsari.service;

import kr.domi.udonsari.vo.MatchingVO;

import kr.domi.udonsari.model.defaultRes;
import kr.domi.udonsari.utils.ResponseMessage;
import kr.domi.udonsari.utils.StatusCode;
import org.springframework.stereotype.Service;
import java.util.List;


public interface MatchingDao {
    /*
     * 유저의 매칭정보 조회
     * param matchingVO
     * return Exception
     * */
    DefaultRes<List<MatchingVO>> selectMatchedInfo(MatchingVO matchingVO) throws Exception;
}