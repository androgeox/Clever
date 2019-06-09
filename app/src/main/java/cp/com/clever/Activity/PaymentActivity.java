package cp.com.clever.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cp.com.clever.R;
import cp.com.clever.model.Travel;
import cp.com.clever.service.RetrofitClient;
import cp.com.clever.service.TravelAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static cp.com.clever.service.RetrofitClient.BASE_URL;

public class PaymentActivity extends AppCompatActivity  implements View.OnClickListener{

//    public static final String BASE_URL = "http://192.168.43.56:8080";
    private Button go_btn_pay;
    private EditText number_ts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        go_btn_pay = findViewById(R.id.go_but_pay);
        go_btn_pay.setOnClickListener(this);
        number_ts = (EditText)findViewById(R.id.text_field);

    }

    @Override
    public void onClick(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TravelAPI apiService =
                retrofit.create(TravelAPI.class);

        Travel travel = new Travel(1234, 345, null, 200, "one");
        Call<Travel> call = apiService.createData(travel);


//        Data data = new Data(1234, 345, null, 200, "one");
//        data.setTsId(number_ts.getText().charAt(0));
//        Call<Data> call = RetrofitClient
//                .getInstance()
//                .getApi()
//                .createData(new Data(1234, 345, null, 200, "one"));

        call.enqueue(new Callback<Travel>() {
            @Override
            public void onResponse(Call<Travel> call, Response<Travel> response) {
//                if (response.isSuccessful()){
//                    String s = response.body().toString();
//                    Toast.makeText(PaymentActivity.this, s,Toast.LENGTH_SHORT).show();
//                }
            }

            @Override
            public void onFailure(Call<Travel> call, Throwable t) {
                Toast.makeText(PaymentActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

        Intent i  = new Intent(this, BuyActivity.class);
        i.putExtra("travel_id", travel.getId());
        startActivity(i);
    }



}
