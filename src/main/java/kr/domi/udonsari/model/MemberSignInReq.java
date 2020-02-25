package kr.domi.udonsari.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignInReq {
    //로그인 요청 객체
    private String uid;
    private String pwd;
    private String hashPwd;
}
