package kr.domi.udonsari.vo;

// 선택된 유저의 프로필 조회
public class ProfileVO {
    private int user_idx;
    private int matching_user_idx;
    private String image;
    private String name;
    private String address;
    private String job;
    private String favorite;
    private String comment;
    private int gender;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }
}