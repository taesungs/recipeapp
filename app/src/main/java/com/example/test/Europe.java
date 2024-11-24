package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Europe extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.europe); // Korea 화면의 레이아웃 파일

        // Korea1로 이동하는 버튼
        ImageButton buttonEurope1 = findViewById(R.id.europe1); // korea.xml에 있는 버튼의 ID
        buttonEurope1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Korea1.java로 화면 전환
                Intent intent = new Intent(Europe.this, Europe1.class);
                startActivity(intent);
            }
        });

        ImageButton buttonEurope2 = findViewById(R.id.europe2); // korea.xml에 있는 버튼의 ID
        buttonEurope2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Korea1.java로 화면 전환
                Intent intent = new Intent(Europe.this, Europe2.class);
                startActivity(intent);
            }
        });

        // China로 이동하는 버튼
        Button buttonChina = findViewById(R.id.china); // korea.xml에 있는 버튼의 ID
        buttonChina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(Europe.this, China.class);
                startActivity(intent);
            }
        });

        Button buttonJapn = findViewById(R.id.korea); // korea.xml에 있는 버튼의 ID
        buttonJapn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(Europe.this, Korea.class);
                startActivity(intent);
            }
        });

        Button buttonEurope = findViewById(R.id.japan); // korea.xml에 있는 버튼의 ID
        buttonEurope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(Europe.this, Japan.class);
                startActivity(intent);
            }
        });
    }
}
