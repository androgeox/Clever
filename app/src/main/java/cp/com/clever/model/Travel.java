package cp.com.clever.model;

import android.annotation.SuppressLint;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;


public class Travel {

    @SerializedName("ts_id")
    @Expose
    int tsId;

    @SerializedName("td_id")
    int tdid; //проездной документ
    @SerializedName("date_poezd")
    Date Date_Poezd;
    @SerializedName("cost_travel")
    int costTravel;
    @SerializedName("vid_plat")
    String vid_plat;

    public Travel(int tsId, int tdid, Date date_Poezd, int costTravel, String vid_plat) {
        this.tsId = tsId;
        this.tdid = tdid;
        Date_Poezd = date_Poezd;
        this.costTravel = costTravel;
        this.vid_plat = vid_plat;
    }

    public Travel() {
    }

    public Travel(int id) {
        this.tsId = id;
    }

    public int getTsId() {
        return tsId;
    }

    public void setTsId(int tsId) {
        this.tsId = tsId;
    }

    public Integer getTdid() {
        return tdid;
    }

    public void setTdid(Integer tdid) {
        this.tdid = tdid;
    }

    public Date getDate_Poezd() {
        return Date_Poezd;
    }

    public void setDate_Poezd(Date date_Poezd) {
        Date_Poezd = date_Poezd;
    }

    public Integer getCostTravel() {
        return costTravel;
    }

    public void setCostTravel(Integer costTravel) {
        this.costTravel = costTravel;
    }

    public String getVid_plat() {
        return vid_plat;
    }

    public void setVid_plat(String vid_plat) {
        this.vid_plat = vid_plat;
    }

}
