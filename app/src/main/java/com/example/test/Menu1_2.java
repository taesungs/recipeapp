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

public class Menu1_2 extends AppCompatActivity {

    private CheckBox[] checkBox = new CheckBox[4];
    private int[] checkBoxID = {R.id.item1_2_1, R.id.item1_2_2, R.id.item1_2_3, R.id.item1_2_4};
    int i;
    private Button shopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1_2);

        Button buttonMove = findViewById(R.id.move1_2); // korea.xml에 있는 버튼의 ID
        buttonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // China.java로 화면 전환
                Intent intent = new Intent(Menu1_2.this, ShopActivity.class);
                startActivity(intent);
            }
        });

        Button favorButton = findViewById(R.id.favor1_2);
        favorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("FavorPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                // Retrieve existing favorites
                Set<String> favorites = sharedPreferences.getStringSet("favor_buttons", new HashSet<>());
                // Add the current button name (ensure no duplicates)
                favorites.add("김(이모카세 1호)"); // Replace "Menu1_1" with the corresponding screen name dynamically if needed
                // Save updated favorites
                editor.putStringSet("favor_buttons", favorites);
                editor.apply();

                Toast.makeText(Menu1_2.this, "즐겨찾기에 레시피 추가", Toast.LENGTH_SHORT).show();
            }
        });


        for(i=0;i<checkBoxID.length;i++){
            checkBox[i] = (CheckBox) findViewById(checkBoxID[i]);
        }
        shopButton = findViewById(R.id.shop1_2);

        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> selectedItems = new ArrayList<>();

                for(i=0;i<checkBoxID.length;i++) {
                    if(checkBox[i].isChecked()){
                        selectedItems.add(checkBox[i].getText().toString());

                    }
                }

                // 데이터를 Shop 싱글톤 클래스에 저장
                Shop.getInstance().updateData(selectedItems);
            }
        });
    }
}
