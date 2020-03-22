package kr.domi.udonsari.dao;

import kr.domi.udonsari.vo.SwipeVO;

import kr.domi.udonsari.model.defaultRes;
import kr.domi.udonsari.utils.ResponseMessage;
import kr.domi.udonsari.utils.StatusCode;
import org.springframework.stereotype.Service;
import java.util.List;

public interface SwipeDao {
    /*
    * 매칭 유저 조회
    * param swipeVO
    * return Exception
    * */
    List<SwipeVO> selectSwipeUserList(SwipeVO swipeVO) throws Exception;

    /*
     * 매칭 판별
     * param swipeVO
     * return Exception
     * */
    void insertSwipeUser(SwipeVO swipeVO) throws Exception;
}
