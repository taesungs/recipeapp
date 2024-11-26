package com.example.test;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Frag1 extends Fragment {

    TextView tvSortedRatings;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag1, container, false);
        tvSortedRatings = view.findViewById(R.id.tv_sorted_ratings);

        // 평점 데이터 불러오기 및 정렬
        loadAndDisplaySortedRatings();

        return view;
    }

    private void loadAndDisplaySortedRatings() {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("RatingData", getContext().MODE_PRIVATE);
        Map<String, ?> allRatings = sharedPreferences.getAll();

        // 평점 데이터를 리스트로 저장
        List<Map.Entry<String, Float>> ratingList = new ArrayList<>();
        for (Map.Entry<String, ?> entry : allRatings.entrySet()) {
            if (entry.getValue() instanceof Float) {
                ratingList.add(Map.entry(entry.getKey(), (Float) entry.getValue()));
            }
        }

        // 내림차순 정렬
        Collections.sort(ratingList, new Comparator<Map.Entry<String, Float>>() {
            @Override
            public int compare(Map.Entry<String, Float> o1, Map.Entry<String, Float> o2) {
                return Float.compare(o2.getValue(), o1.getValue()); // 내림차순
            }
        });

        // 정렬된 데이터를 문자열로 변환
        StringBuilder sortedRatings = new StringBuilder();
        for (Map.Entry<String, Float> entry : ratingList) {
            sortedRatings.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        if (sortedRatings.length() == 0) {
            sortedRatings.append("등록된 평점이 없습니다.");
        }

        // 텍스트뷰에 표시
        tvSortedRatings.setText(sortedRatings.toString());
    }
}
