package kr.domi.udonsari.service;

import kr.domi.udonsari.vo.SariChatVO;

import kr.domi.udonsari.model.defaultRes;
import kr.domi.udonsari.utils.ResponseMessage;
import kr.domi.udonsari.utils.StatusCode;
import org.springframework.stereotype.Service;
import java.util.List;


public interface SariChatDao {
    /*
     * 1:1 채팅방 조회
     * param sariChatVO
     * return Exception
     * */
    DefaultRes<List<SariChatVO>> selectSariChatList(SariChatVO sariChatVO) throws Exception;
}