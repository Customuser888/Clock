package com.example.log;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.alarm);
    }

    //Функции для перехода на другие экраны
    public void Alarm(View view) {
        setContentView(R.layout.alarm);
    }

    public void Clock(View view) {
        setContentView(R.layout.clock);
    }

    public void StopWach(View view) {
        setContentView(R.layout.stop_watch);
    }

    public void Timer(View view) {
        setContentView(R.layout.timer);
    }

    public void Alarm_Setup(View view) {
        setContentView(R.layout.alarm_setup);
    }


}
