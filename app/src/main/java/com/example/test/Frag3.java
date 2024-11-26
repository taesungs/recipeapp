package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Frag3 extends Fragment {

    private View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag3, container, false);

        ImageButton rating1_1Button = view.findViewById(R.id.rating1_1);
        rating1_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Rating1_1.class);
                startActivity(intent);
            }
        });

        ImageButton rating1_2Button = view.findViewById(R.id.rating1_2);
        rating1_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Rating1_2.class);
                startActivity(intent);
            }
        });

        ImageButton rating2_1Button = view.findViewById(R.id.rating2_1);
        rating2_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Rating2_1.class);
                startActivity(intent);
            }
        });

        ImageButton rating2_2Button = view.findViewById(R.id.rating2_2);
        rating2_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Rating2_2.class);
                startActivity(intent);
            }
        });

        ImageButton rating3_1Button = view.findViewById(R.id.rating3_1);
        rating3_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Rating3_1.class);
                startActivity(intent);
            }
        });

        ImageButton rating3_2Button = view.findViewById(R.id.rating3_2);
        rating3_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Rating3_2.class);
                startActivity(intent);
            }
        });

        ImageButton rating4_1Button = view.findViewById(R.id.rating4_1);
        rating4_1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Rating4_1.class);
                startActivity(intent);
            }
        });

        ImageButton rating4_2Button = view.findViewById(R.id.rating4_2);
        rating4_2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Rating4_2.class);
                startActivity(intent);
            }
        });


        return view;
    }
}