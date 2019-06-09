package cp.com.clever.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

import cp.com.clever.R;
import cp.com.clever.model.BuyTicket;
import cp.com.clever.model.Travel;
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
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        id_pokupki = findViewById(R.id.id_pokupki);
        buyDate = findViewById(R.id.buyDate);
        buyCost = findViewById(R.id.buyCost);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }   // get data via the key
        int travel_id = extras.getInt(Intent.EXTRA_INDEX);


        Call<BuyTicket> call = RetrofitClient
                .getInstance()
                .getApi()
                .getInfoTicket(travel_id);

        call.enqueue(new Callback<BuyTicket>() {
            @Override
            public void onResponse(Call<BuyTicket> call, Response<BuyTicket> response) {
                if (response.isSuccessful()){
                    int id = response.body().getId();
                    int price = response.body().getPrice();
                    Date date = response.body().getBuyDate();
                    id_pokupki.setText(id);
                    buyCost.setText(price);
                    buyDate.setText(date.toString());
                }
            }

            @Override
            public void onFailure(Call<BuyTicket> call, Throwable t) {
                Toast.makeText(BuyActivity.this, "error", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
