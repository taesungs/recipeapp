package com.example.test;

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
            }
        });

    }
}
