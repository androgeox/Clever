package cp.com.clever.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import cp.com.clever.R;
import cp.com.clever.model.Buy;
import cp.com.clever.service.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BuyActivity extends AppCompatActivity {

    TextView id_pokupki;
    TextView buyDate;
    TextView buyCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        id_pokupki = findViewById(R.id.id_pokupki);
        buyDate = findViewById(R.id.buyDate);
        buyCost = findViewById(R.id.buyCost);

        id_pokupki.setText("1");
        buyDate.setText("07.06.2018");
        buyCost.setText("45 руб");

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }   // get data via the key
        int travel_id = extras.getInt("travel_id");


        Call<Buy> call = RetrofitClient
                .getInstance()
                .getApi()
                .getInfoTicket(travel_id);

        call.enqueue(new Callback<Buy>() {
            @Override
            public void onResponse(Call<Buy> call, Response<Buy> response) {
                if (response.isSuccessful()){

                    if (response.body() != null) {
                        int id = response.body().getId();
                        int price = response.body().getPrice();
                        Date date = response.body().getBuyDate();
                        id_pokupki.setText(id);
                        buyCost.setText(price);
                        buyDate.setText(date.toString());
                    }
                    else
                        Toast.makeText(BuyActivity.this, "responce == null", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Buy> call, Throwable t) {
                Toast.makeText(BuyActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
