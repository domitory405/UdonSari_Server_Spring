package kr.domi.udonsari.vo;

// 유저의 매칭정보 조회
public class MatchingVO {
    private int user_idx;
    private int matching_user_idx;
    private String image;
    private String name;
    private int room_state; // 룸이 열렸는지 상태정보
    private int sari_matching_dt;   // 사리 매칭된 날짜
    private int create_dt;  // 룸이 생성된 날짜


    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
    }

    public int getMatching_user_idx() {
        return matching_user_idx;
    }

    public void setMatching_user_idx(int matching_user_idx) {
        this.matching_user_idx = matching_user_idx;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoom_state() {
        return room_state;
    }

    public void setRoom_state(int room_state) {
        this.room_state = room_state;
    }

    public int getSari_matching_dt() {
        return sari_matching_dt;
    }

    public void setSari_matching_dt(int sari_matching_dt) {
        this.sari_matching_dt = sari_matching_dt;
    }

    public int getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(int create_dt) {
        this.create_dt = create_dt;
    }
}
