package com.example.weatherappcsce3444;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    EditText edtSearch;
    Button btnSearch, btnNextDays;
    TextView txtName, txtCountry, txtTemp, txtStatus, txtHumidity, txtCloud, txtMill, txtUpdatedDay;
    ImageView imgIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String city = edtSearch.getText().toString();
                getCurrentWeatherData(city);
            }
        });
    }

    public void getCurrentWeatherData(String data){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+data+"&units=imperial&appid=9fb7df5c9a82e5f3e5c0a60e9c94348b";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("result",response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(stringRequest);
    }
    private void mapping() {
        edtSearch = (EditText) findViewById(R.id.editTextSearch);
        btnSearch = (Button) findViewById(R.id.buttonSearch);
        btnNextDays = (Button) findViewById(R.id.buttonNextDays);
        txtName = (TextView) findViewById(R.id.textViewCity);
        txtCountry = (TextView) findViewById(R.id.textViewCountry);
        txtTemp = (TextView) findViewById(R.id.textViewTemperature);
        txtStatus = (TextView) findViewById(R.id.textViewStatus);
        txtHumidity = (TextView) findViewById(R.id.textViewHumidity);
        txtCloud = (TextView) findViewById(R.id.textViewCloud);
        txtMill = (TextView) findViewById(R.id.textViewMill);
        txtUpdatedDay = (TextView) findViewById(R.id.textViewDate);
        imgIcon = (ImageView) findViewById(R.id.imageViewIcon);
    }
}