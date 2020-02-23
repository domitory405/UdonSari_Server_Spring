package kr.domi.udonsari.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDto {
    private int user_idx;
    private String uid;
    private String pwd;
    private String salt;
    private String name;
    private String address;
    private String job;
    private String favorite;
    private String comment;
    private int gender;
    private String image;
    private String gps;
}
