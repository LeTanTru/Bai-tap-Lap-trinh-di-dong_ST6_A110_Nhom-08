package com.example.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    Button btnRandom;
    EditText txtLength;
    private static final String TAG = "RandomNumbers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnRandom = (Button) findViewById(R.id.btnRandom);
        txtLength = (EditText) findViewById(R.id.txtLength);
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int length = Integer.parseInt(txtLength.getText().toString());
                ArrayList<Integer> randomList = new ArrayList<>();
                Random random = new Random();
                for (int i = 0; i < length; i++) {
                    int randomNumber = random.nextInt(100) + 1;
                    randomList.add(randomNumber);
                }

                ArrayList<Integer> evenList = new ArrayList<>();
                ArrayList<Integer> oddList = new ArrayList<>();

                for (int number : randomList) {
                    if (number % 2 == 0) {
                        evenList.add(number);
                    } else {
                        oddList.add(number);
                    }
                }
                Log.d(TAG, "Số chẵn: " + evenList);
                Log.d(TAG, "Số lẻ: " + oddList);
            }
        });
    }
}