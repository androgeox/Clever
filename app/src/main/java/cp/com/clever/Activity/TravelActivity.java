package cp.com.clever.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import cp.com.clever.R;

public class TravelActivity extends AppCompatActivity implements View.OnClickListener{


    private Button qr_but_travel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        qr_but_travel = findViewById(R.id.go_btn_travel);
        textView = (TextView)findViewById(R.id.show_cost_travel);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        String value = extras.getString("value");
        if (value != null) {
            textView.setText(value);
        }
        else
            Toast.makeText(this, "error",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {

    }
}
