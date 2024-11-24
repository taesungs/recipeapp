package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Europe2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.europe2); // Korea 화면의 레이아웃 파일

        // 버튼을 찾아서 클릭 이벤트 설정
        ImageButton button = findViewById(R.id.menu4_2); // korea.xml에 있는 버튼의 ID
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Korea1.java로 화면 전환
                Intent intent = new Intent(Europe2.this, Menu4_2.class);
                startActivity(intent);
            }
        });




    }
}
