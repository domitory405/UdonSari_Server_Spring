package kr.domi.udonsari.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TokenRes {
    private String token;
    private int userIdx;

    public TokenRes(String token, int userIdx) {
        this.token = token;
        this.userIdx = userIdx;
    }
}
