package kr.domi.udonsari.vo;

// 1:1 채팅방 리스트 조회
public class SariChatVO {
    private int user_idx;
    private String image;
    private String name;
    private int sari_room_idx;
    private String create_dt;
    private int room_state;
    private String timestamp;
    private String message;
    private int sender_idx;

    public int getUser_idx() {
        return user_idx;
    }

    public void setUser_idx(int user_idx) {
        this.user_idx = user_idx;
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

    public int getSari_room_idx() {
        return sari_room_idx;
    }

    public void setSari_room_idx(int sari_room_idx) {
        this.sari_room_idx = sari_room_idx;
    }

    public String getCreate_dt() {
        return create_dt;
    }

    public void setCreate_dt(String create_dt) {
        this.create_dt = create_dt;
    }

    public int getRoom_state() {
        return room_state;
    }

    public void setRoom_state(int room_state) {
        this.room_state = room_state;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSender_idx() {
        return sender_idx;
    }

    public void setSender_idx(int sender_idx) {
        this.sender_idx = sender_idx;
    }
}