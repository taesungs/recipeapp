package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Set;

public class Favor extends AppCompatActivity {

    private LinearLayout buttonContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favor);

        buttonContainer = findViewById(R.id.buttonContainer);

        // Retrieve and display all favorites
        loadFavorites();

        // Set up Clear Favorites button
        Button clearButton = findViewById(R.id.clearFavorites);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFavorites();
            }
        });
    }

    private void loadFavorites() {
        SharedPreferences sharedPreferences = getSharedPreferences("FavorPrefs", MODE_PRIVATE);
        Set<String> favorites = sharedPreferences.getStringSet("favor_buttons", null);

        if (favorites != null) {
            for (String buttonName : favorites) {
                addButton(buttonName);
            }
        }
    }

    private void addButton(String buttonName) {
        Button newButton = new Button(this);
        newButton.setText(buttonName);
        newButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        // Set up the click listener to navigate to the corresponding activity
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (buttonName.equals("제육볶음(급식대가)")) {
                    Intent intent = new Intent(Favor.this, Menu1_1.class);
                    startActivity(intent);
                } else if (buttonName.equals("김(이모카세 1호)")) {
                    Intent intent = new Intent(Favor.this, Menu1_2.class);
                    startActivity(intent);
                } else if (buttonName.equals("팔보완자(철가방 요리사)")) {
                    Intent intent = new Intent(Favor.this, Menu2_1.class);
                    startActivity(intent);
                } else if (buttonName.equals("시래기바쓰흑초강정(정지선)")) {
                    Intent intent = new Intent(Favor.this, Menu2_2.class);
                    startActivity(intent);
                } else if (buttonName.equals("무 스테이크(최강록)")) {
                    Intent intent = new Intent(Favor.this, Menu3_1.class);
                    startActivity(intent);
                } else if (buttonName.equals("쿠로 다마네기(장호준)")) {
                    Intent intent = new Intent(Favor.this, Menu3_2.class);
                    startActivity(intent);
                } else if (buttonName.equals("밤 티라미수(나폴리 맛피아)")) {
                    Intent intent = new Intent(Favor.this, Menu4_1.class);
                    startActivity(intent);
                } else if (buttonName.equals("알리오올리오(히든천재)")) {
                    Intent intent = new Intent(Favor.this, Menu4_2.class);
                    startActivity(intent);
                }
                // Add more conditions for other menu screens if needed
            }
        });

        buttonContainer.addView(newButton);
    }


    private void clearFavorites() {
        SharedPreferences sharedPreferences = getSharedPreferences("FavorPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // Remove all saved favorites
        editor.remove("favor_buttons");
        editor.apply();

        // Clear dynamically added buttons
        buttonContainer.removeAllViews();
    }
}
