package kr.domi.udonsari.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberSignUpReq {
    //회원가입 시 Req 데이터
    private String uid;
    private String pwd;
    private String name;
    private String address;
    private String job;
    private String favorite;
    private String comment;
    private String salt;
    private int gender;
    private String image;
    private String gps;
}
