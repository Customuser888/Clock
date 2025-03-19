package com.example.timer;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView timerTextView;
    private EditText timeInput;
    private Button startButton, pauseButton, stopButton;
    private Handler handler;
    private Runnable runnable;
    private int totalTimeInSeconds = 0; // Общее время в секундах
    private int remainingTimeInSeconds = 0; // Оставшееся время в секундах
    private boolean isRunning = false;
    private boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerTextView = findViewById(R.id.timerTextView);
        timeInput = findViewById(R.id.timeInput);
        startButton = findViewById(R.id.startButton);
        pauseButton = findViewById(R.id.pauseButton);
        stopButton = findViewById(R.id.stopButton);

        handler = new Handler();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseTimer();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });
    }

    private void startTimer() {
        if (!isRunning) {
            String input = timeInput.getText().toString();
            if (input.isEmpty()) {
                timeInput.setError("Введите время в формате MM:SS");
                return;
            }

            // Преобразуем введенное время в секунды
            String[] parts = input.split(":");
            int minutes = Integer.parseInt(parts[0]);
            int seconds = Integer.parseInt(parts[1]);
            totalTimeInSeconds = minutes * 60 + seconds;
            remainingTimeInSeconds = totalTimeInSeconds;

            isRunning = true;
            isPaused = false;
            updateTimerDisplay();

            runnable = new Runnable() {
                @Override
                public void run() {
                    if (remainingTimeInSeconds > 0) {
                        remainingTimeInSeconds--;
                        updateTimerDisplay();
                        handler.postDelayed(this, 1000);
                    } else {
                        stopTimer();
                    }
                }
            };
            handler.post(runnable);
        }
    }

    private void pauseTimer() {
        if (isRunning) {
            if (isPaused) {
                // Продолжаем таймер
                handler.post(runnable);
                isPaused = false;
                pauseButton.setText("Pause");
            } else {
                // Ставим на паузу
                handler.removeCallbacks(runnable);
                isPaused = true;
                pauseButton.setText("Resume");
            }
        }
    }

    private void stopTimer() {
        if (isRunning) {
            isRunning = false;
            isPaused = false;
            handler.removeCallbacks(runnable);
            remainingTimeInSeconds = 0;
            updateTimerDisplay();
            pauseButton.setText("Pause");
        }
    }

    private void updateTimerDisplay() {
        int minutes = remainingTimeInSeconds / 60;
        int seconds = remainingTimeInSeconds % 60;
        String time = String.format("%02d:%02d", minutes, seconds);
        timerTextView.setText(time);
    }
}
