package kr.domi.udonsari.utils;

public class ResponseMessage {
    /*
    * Auth
    */
    public static final String ALREADY_USER = "이미 존재하는 ID 입니다.";
    public static final String CREATED_USER = "회원가입 성공";
    public static final String LOGIN_SUCCESS = "로그인 성공";
    public static final String LOGIN_FAIL = "로그인 실패";

    /*
    * 기본 서버 에러
    * */
    public static final String DB_ERROR = "데이터베이스 오류";
    public static final String INTERNAL_SERVER_ERROR = "서버 내부 에러";

    /*
    * GPS 변경
    * */
    public static final String MATCH_GPS = "GPS가 유효합니다.";
    public static final String CHANGE_GPS = "GPS 위치가 변경되었습니다.";
}
