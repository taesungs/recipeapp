package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Korea extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.korea); // Korea 화면의 레이아웃 파일

        // Korea1로 이동하는 버튼
        ImageButton buttonKorea1 = findViewById(R.id.korea1); // korea.xml에 있는 버튼의 ID
        buttonKorea1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Korea1.java로 화면 전환
                Intent intent = new Intent(Korea.this, Korea1.class);
                startActivity(intent);
            }
        });

        ImageButton buttonKorea2 = findViewById(R.id.korea2); // korea.xml에 있는 버튼의 ID
        buttonKorea2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Korea1.java로 화면 전환
                Intent intent = new Intent(Korea.this, Korea2.class);
                startActivity(intent);
            }
        });

        // China로 이동하는 버튼
        Button buttonChina = findViewById(R.id.china); // korea.xml에 있는 버튼의 ID
        buttonChina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(Korea.this, China.class);
                startActivity(intent);
            }
        });

        Button buttonJapn = findViewById(R.id.japan); // korea.xml에 있는 버튼의 ID
        buttonJapn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(Korea.this, Japan.class);
                startActivity(intent);
            }
        });

        Button buttonEurope = findViewById(R.id.europe); // korea.xml에 있는 버튼의 ID
        buttonEurope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(Korea.this, Europe.class);
                startActivity(intent);
            }
        });
    }
}
