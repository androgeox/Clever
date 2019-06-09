package cp.com.clever.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class BuyTicket {

    @SerializedName("id_pokupki")
    int id;

    @SerializedName("fn_ns")
     int fn_ns;

    @SerializedName("orderCardId")
     Integer orderCardId;  //id_PS

    @SerializedName("TravelDocumentId")
     Integer TravelDocumentId; //ID_PD

    @SerializedName("price")
     Integer price;  //Sum

    @SerializedName("buyDate")
     Date buyDate;

    public BuyTicket(int id, int fn_ns, Integer orderCardId, Integer travelDocumentId, Integer price, Date buyDate) {
        this.id = id;
        this.fn_ns = fn_ns;
        this.orderCardId = orderCardId;
        TravelDocumentId = travelDocumentId;
        this.price = price;
        this.buyDate = buyDate;
    }

    public BuyTicket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFn_ns() {
        return fn_ns;
    }

    public void setFn_ns(int fn_ns) {
        this.fn_ns = fn_ns;
    }

    public Integer getOrderCardId() {
        return orderCardId;
    }

    public void setOrderCardId(Integer orderCardId) {
        this.orderCardId = orderCardId;
    }

    public Integer getTravelDocumentId() {
        return TravelDocumentId;
    }

    public void setTravelDocumentId(Integer travelDocumentId) {
        TravelDocumentId = travelDocumentId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }
}
