package cp.com.clever.service;

import cp.com.clever.model.Buy;
import cp.com.clever.model.Travel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TravelAPI {
    //    @FormUrlEncoded
    @POST("/travel/new")
    Call<Travel> createData(@Body Travel travel);
//    Call<Data> createData(@Field("TSId") int tsid,
//                          @Field("TDId") int tdid,
//                          @Field("Date_Poezd")Date date,
//                          @Field("costTravel") int costTravel,
//                          @Field("vid_plat") String vid_plat);

    @GET("/ticket/{id}")
    Call<Buy> getInfoTicket(@Path("id") int id);

}
