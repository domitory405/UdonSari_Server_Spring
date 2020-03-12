package kr.domi.udonsari.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class GpsReq {
    private int idx;
    private String regCode;
}
