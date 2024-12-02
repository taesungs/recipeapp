package com.example.test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Menu2_1 extends AppCompatActivity {

    private CheckBox[] checkBox = new CheckBox[20];
    private int[] checkBoxID = {R.id.item2_1_1, R.id.item2_1_2, R.id.item2_1_3, R.id.item2_1_4, R.id.item2_1_5, R.id.item2_1_6,
            R.id.item2_1_7, R.id.item2_1_8, R.id.item2_1_9, R.id.item2_1_10, R.id.item2_1_11, R.id.item2_1_12, R.id.item2_1_13,R.id.item2_1_14,R.id.item2_1_15
    ,R.id.item2_1_16,R.id.item2_1_17,R.id.item2_1_18,R.id.item2_1_19,R.id.item2_1_20};
    int i;
    private Button shopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu2_1);

        Button buttonMove = findViewById(R.id.move2_1); // korea.xml에 있는 버튼의 ID
        buttonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(Menu2_1.this, ShopActivity.class);
                startActivity(intent);
            }
        });

        Button favorButton = findViewById(R.id.favor2_1);
        favorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("FavorPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // Retrieve existing favorites
                Set<String> favorites = sharedPreferences.getStringSet("favor_buttons", new HashSet<>());
                // Add the current button name (ensure no duplicates)
                favorites.add("팔보완자(철가방 요리사)"); // Replace "Menu1_1" with the corresponding screen name dynamically if needed
                // Save updated favorites
                editor.putStringSet("favor_buttons", favorites);
                editor.apply();

                Toast.makeText(Menu2_1.this, "즐겨찾기에 레시피 추가", Toast.LENGTH_SHORT).show();
            }
        });

        for(i=0;i<checkBoxID.length;i++){
            checkBox[i] = (CheckBox) findViewById(checkBoxID[i]);
        }
        shopButton = findViewById(R.id.shop2_1);

        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> selectedItems = new ArrayList<>();

                for(i=0;i<checkBoxID.length;i++) {
                    if(checkBox[i].isChecked()){
                        selectedItems.add(checkBox[i].getText().toString());

                    }
                }

                // 데이터를 Shop 싱글톤 클래스에 저장 (추가)
                Shop.getInstance().addData(selectedItems);
            }
        });
    }
}
