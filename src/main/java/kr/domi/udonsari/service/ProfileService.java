package kr.domi.udonsari.service;

import kr.domi.udonsari.vo.ProfileVO;

import kr.domi.udonsari.model.defaultRes;
import kr.domi.udonsari.utils.ResponseMessage;
import kr.domi.udonsari.utils.StatusCode;
import org.springframework.stereotype.Service;
import java.util.List;


public interface ProfileDao {
    /*
     * 선택한 유저의 프로필 조회
     * param profileVO
     * return Exception
     * */
    DefaultRes<List<ProfileVO>> selectProfileInfo(ProfileVO profileVO) throws Exception;
}