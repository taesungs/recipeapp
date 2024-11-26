package com.example.test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Rating extends AppCompatActivity {

    TextView tvAllRatings;
    Button btnResetRatings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating);

        tvAllRatings = findViewById(R.id.tv_all_ratings);
        btnResetRatings = findViewById(R.id.btn_reset_ratings);

        // 저장된 평점 데이터를 불러와 화면에 표시
        loadRatings();

        // 초기화 버튼 클릭 리스너 설정
        btnResetRatings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetRatings();
            }
        });
    }

    private void loadRatings() {
        SharedPreferences sharedPreferences = getSharedPreferences("RatingData", MODE_PRIVATE);

        StringBuilder allRatings = new StringBuilder();
        float rating1_1 = sharedPreferences.getFloat("제육볶음(급식대가)", -1);
        float rating1_2 = sharedPreferences.getFloat("김(이모카세 1호)", -1);
        float rating2_1 = sharedPreferences.getFloat("팔보완자(철가방 요리사)", -1);
        float rating2_2 = sharedPreferences.getFloat("시래기바쓰흑초강정(정지선)", -1);
        float rating3_1 = sharedPreferences.getFloat("무 스테이크(최강록)", -1);
        float rating3_2 = sharedPreferences.getFloat("쿠로 다마네기(장호준)", -1);
        float rating4_1 = sharedPreferences.getFloat("밤 티라미수(나폴리 맛피아)", -1);
        float rating4_2 = sharedPreferences.getFloat("알리오올리오(히든천재)", -1);

        // 저장된 평점들을 확인하여 문자열로 합침
        if (rating1_1 != -1) {
            allRatings.append("제육볶음(급식대가): ").append(rating1_1).append("\n");
        }
        if (rating1_2 != -1) {
            allRatings.append("김(이모카세 1호): ").append(rating1_2).append("\n");
        }
        if (rating2_1 != -1) {
            allRatings.append("팔보완자(철가방 요리사): ").append(rating2_1).append("\n");
        }
        if (rating2_2 != -1) {
            allRatings.append("시래기바쓰흑초강정(정지선): ").append(rating2_2).append("\n");
        }
        if (rating3_1 != -1) {
            allRatings.append("무 스테이크(최강록): ").append(rating3_1).append("\n");
        }
        if (rating3_2 != -1) {
            allRatings.append("쿠로 다마네기(장호준): ").append(rating3_2).append("\n");
        }
        if (rating4_1 != -1) {
            allRatings.append("밤 티라미수(나폴리 맛피아): ").append(rating4_1).append("\n");
        }
        if (rating4_2 != -1) {
            allRatings.append("알리오올리오(히든천재): ").append(rating4_2).append("\n");
        }

        if (allRatings.length() == 0) {
            allRatings.append("등록된 평점이 없습니다..");
        }

        // 텍스트뷰에 표시
        tvAllRatings.setText(allRatings.toString());
    }

    private void resetRatings() {
        // SharedPreferences 데이터 초기화
        SharedPreferences sharedPreferences = getSharedPreferences("RatingData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear(); // 모든 데이터 삭제
        editor.apply(); // 변경 적용

        // 초기화 메시지로 업데이트
        tvAllRatings.setText("등록된 평점이 없습니다.");
    }
}
