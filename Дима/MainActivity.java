package com.example.clock;

import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;


public class MainActivity extends AppCompatActivity {

    //Переход на главный экран при открытии приложения
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.alarm);
    }

    //Функции для перехода на другие экраны
    public void alarm(View view) {
        setContentView(R.layout.alarm);
    }

    public void clock(View view) {
        setContentView(R.layout.clock);
    }

    public void stopWach(View view) {
        setContentView(R.layout.stop_watch);
    }

    public void timer(View view) {
        setContentView(R.layout.timer);
    }

    public void alarmSetup(View view) {
        setContentView(R.layout.alarm_setup);
    }

    //Функция для добавления нового будильника
    public void addAlarm(View view) {
        setContentView(R.layout.alarm);
        LinearLayout buttonContainer = (LinearLayout) findViewById(R.id.buttonContainer);
        Button button = new Button(MainActivity.this);
        buttonContainer.addView(button);

    }
    //Функция для активации будильника
    public void activateAlarm(View view) {
        //null
    }
    //Функция для удаления будильника
    public void deleteAlarm(View view) {
        //null
    }

}
