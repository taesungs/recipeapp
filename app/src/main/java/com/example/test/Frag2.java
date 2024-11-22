package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag2 extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag2, container, false);

        // Korea.java로 이동하는 Button 설정
        Button koreaButton = view.findViewById(R.id.korea);
        koreaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Korea.class);
                startActivity(intent);
            }
        });

        // China.java로 이동하는 Button 설정
        Button chinaButton = view.findViewById(R.id.china);
        chinaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), China.class);
                startActivity(intent);
            }
        });

        Button japanButton = view.findViewById(R.id.japan);
        japanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Japan.class);
                startActivity(intent);
            }
        });

        Button europeButton = view.findViewById(R.id.europe);
        europeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Europe.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
