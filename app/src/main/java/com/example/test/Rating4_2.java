package com.example.test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Rating4_2 extends AppCompatActivity {

    TextView tvScore;
    Button btnSubmit;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating4_2);

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
                editor.putFloat("알리오올리오(히든천재)", rating); // Rating1_1에 해당하는 키로 저장
                editor.apply();
            }
        });
    }
}
