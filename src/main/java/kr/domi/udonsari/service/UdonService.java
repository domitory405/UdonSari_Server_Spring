package kr.domi.udonsari.service;

import kr.domi.udonsari.dto.MemberDto;
import kr.domi.udonsari.model.DefaultRes;

public interface UdonService {
    String getRegCode(String gps);
    DefaultRes checkReg(MemberDto member, String regCode);
}
