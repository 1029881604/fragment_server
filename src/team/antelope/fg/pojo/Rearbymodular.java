package team.antelope.fg.pojo;

import java.util.Date;

public class Rearbymodular {
    private String type;

    private String needtitle;

    private String needbody;

    private String needimg;

    private String skilltitle;

    private String skillbody;

    private String skillimg;

    private Date needupdatetime;

    private Date skillupdatetime;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getNeedtitle() {
        return needtitle;
    }

    public void setNeedtitle(String needtitle) {
        this.needtitle = needtitle == null ? null : needtitle.trim();
    }

    public String getNeedbody() {
        return needbody;
    }

    public void setNeedbody(String needbody) {
        this.needbody = needbody == null ? null : needbody.trim();
    }

    public String getNeedimg() {
        return needimg;
    }

    public void setNeedimg(String needimg) {
        this.needimg = needimg == null ? null : needimg.trim();
    }

    public String getSkilltitle() {
        return skilltitle;
    }

    public void setSkilltitle(String skilltitle) {
        this.skilltitle = skilltitle == null ? null : skilltitle.trim();
    }

    public String getSkillbody() {
        return skillbody;
    }

    public void setSkillbody(String skillbody) {
        this.skillbody = skillbody == null ? null : skillbody.trim();
    }

    public String getSkillimg() {
        return skillimg;
    }

    public void setSkillimg(String skillimg) {
        this.skillimg = skillimg == null ? null : skillimg.trim();
    }

    public Date getNeedupdatetime() {
        return needupdatetime;
    }

    public void setNeedupdatetime(Date needupdatetime) {
        this.needupdatetime = needupdatetime;
    }

    public Date getSkillupdatetime() {
        return skillupdatetime;
    }

    public void setSkillupdatetime(Date skillupdatetime) {
        this.skillupdatetime = skillupdatetime;
    }
}