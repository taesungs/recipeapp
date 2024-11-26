package com.example.test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Rating2_2 extends AppCompatActivity {

    TextView tvScore;
    Button btnSubmit;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating2_2);

        initView();
    }

    private void initView() {
        btnSubmit = findViewById(R.id.button);
        tvScore = findViewById(R.id.tv_score);
        ratingBar = findViewById(R.id.ratings);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float rating = ratingBar.getRating();
                tvScore.setText(String.valueOf("평점 : " + rating));

                // SharedPreferences에 평점 저장
                SharedPreferences sharedPreferences = getSharedPreferences("RatingData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putFloat("시래기바쓰흑초강정(정지선)", rating); // Rating1_1에 해당하는 키로 저장
                editor.apply();
            }
        });
    }
}
