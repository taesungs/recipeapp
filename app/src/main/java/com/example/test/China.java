package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class China extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.china); // Korea 화면의 레이아웃 파일

        // Korea1로 이동하는 버튼
        ImageButton buttonChina1 = findViewById(R.id.china1); // korea.xml에 있는 버튼의 ID
        buttonChina1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Korea1.java로 화면 전환
                Intent intent = new Intent(China.this, China1.class);
                startActivity(intent);
            }
        });

        ImageButton buttonChina2 = findViewById(R.id.china2); // korea.xml에 있는 버튼의 ID
        buttonChina2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Korea1.java로 화면 전환
                Intent intent = new Intent(China.this, China2.class);
                startActivity(intent);
            }
        });

        // China로 이동하는 버튼
        Button buttonChina = findViewById(R.id.korea); // korea.xml에 있는 버튼의 ID
        buttonChina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(China.this, Korea.class);
                startActivity(intent);
            }
        });

        Button buttonJapn = findViewById(R.id.japan); // korea.xml에 있는 버튼의 ID
        buttonJapn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(China.this, Japan.class);
                startActivity(intent);
            }
        });

        Button buttonEurope = findViewById(R.id.europe); // korea.xml에 있는 버튼의 ID
        buttonEurope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(China.this, Europe.class);
                startActivity(intent);
            }
        });
    }
}
