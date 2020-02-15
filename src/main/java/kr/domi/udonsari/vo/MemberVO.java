package kr.domi.udonsari.vo;

public class MemberVO {
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

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSalt() {
        return salt;
    }

    public String getUid() {
        return uid;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getJob() {
        return job;
    }

    public String getFavorite() {
        return favorite;
    }

    public String getComment() {
        return comment;
    }

    public int getGender() {
        return gender;
    }

    public String getImage() {
        return image;
    }

    public String getGps() {
        return gps;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }
}
