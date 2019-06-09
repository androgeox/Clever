package cp.com.clever.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitClient {

//    public static final String BASE_URL = "http://188.225.10.57:8080";
//    public static final String BASE_URL = "http://192.168.43.56";
    public static final String BASE_URL = "http://10.0.2.2";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;
    private RetrofitClient() {
         retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitClient getInstance(){
        if(mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public TravelAPI getApi(){
        return retrofit.create(TravelAPI.class);
    }

}
