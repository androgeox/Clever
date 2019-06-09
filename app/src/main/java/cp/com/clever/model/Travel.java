package cp.com.clever.model;

import android.annotation.SuppressLint;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.Objects;


public class Travel {

    int id;

    @SerializedName("TSId")
//    @Expose
            Integer tsId;

//    @SerializedName("fio")
//    @Expose
//    private String fio;
//
//    public Data(Integer tsId, String fio) {
//        this.tsId = tsId;
//        this.fio = fio;
//    }

    @SerializedName("TDId")
    int TDId; //проездной документ
    @SerializedName("Date_Poezd")
    Date Date_Poezd;
    @SerializedName("costTravel")
    int costTravel;
    @SerializedName("vid_plat")
    String vid_plat;

    public Travel(int tsId, Integer TDId, Date date_Poezd, Integer costTravel, String vid_plat) {
        this.tsId = tsId;
        this.TDId = TDId;
        Date_Poezd = date_Poezd;
        this.costTravel = costTravel;
        this.vid_plat = vid_plat;
    }

    public Travel() {
    }

    public int getTsId() {
        return tsId;
    }

    public void setTsId(int tsId) {
        this.tsId = tsId;
    }

    public Integer getTDId() {
        return TDId;
    }

    public void setTDId(Integer TDId) {
        this.TDId = TDId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @SuppressLint("NewApi")
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Travel)) return false;
        Travel travel = (Travel) o;
        return getId() == travel.getId() &&
                getTDId() == travel.getTDId() &&
                getCostTravel() == travel.getCostTravel() &&
                Objects.equals(getTsId(), travel.getTsId()) &&
                Objects.equals(getDate_Poezd(), travel.getDate_Poezd()) &&
                Objects.equals(getVid_plat(), travel.getVid_plat());
    }

    @SuppressLint("NewApi")
    @Override
    public int hashCode() {

        return Objects.hash(getId(), getTsId(), getTDId(), getDate_Poezd(), getCostTravel(), getVid_plat());
    }
}
