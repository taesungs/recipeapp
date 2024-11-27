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

public class Menu1_1 extends AppCompatActivity {

    private CheckBox[] checkBox = new CheckBox[13];
    private int[] checkBoxID = {R.id.item1_1_1, R.id.item1_1_2, R.id.item1_1_3, R.id.item1_1_4, R.id.item1_1_5, R.id.item1_1_6,
            R.id.item1_1_7, R.id.item1_1_8, R.id.item1_1_9, R.id.item1_1_10, R.id.item1_1_11, R.id.item1_1_12, R.id.item1_1_13};
    int i;
    private Button shopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1_1);

        Button buttonMove = findViewById(R.id.move1_1);
        buttonMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu1_1.this, ShopActivity.class);
                startActivity(intent);
            }
        });

        Button favorButton = findViewById(R.id.favor1_1);
        favorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //getSharedPreferences() 메서드를 사용하여 SharedPreferences 객체를 초기화
                //첫 번째 매개변수는 저장소 이름(FavorPrefs)이고, 두 번째 매개변수는 모드(일반적으로 MODE_PRIVATE)
                SharedPreferences sharedPreferences = getSharedPreferences("FavorPrefs", MODE_PRIVATE);
                //데이터를 저장하기 위해 SharedPreferences.Editor 객체를 사용
                SharedPreferences.Editor editor = sharedPreferences.edit();

                //저장된 데이터를 불러오려면 getStringSet() 메서드를 사용
                //Set<String> 두 번째 매개변수는 데이터가 없을 경우 사용할 기본값(여기서는 빈 HashSet)
                Set<String> favorites = sharedPreferences.getStringSet("favor_buttons", new HashSet<>());
                favorites.add("제육볶음(급식대가)");
                //putStringSet() 메서드를 통해 데이터를 저장
                editor.putStringSet("favor_buttons", favorites);
                //apply() 메서드를 호출해 데이터를 비동기적으로 저장
                editor.apply();

                Toast.makeText(Menu1_1.this, "즐겨찾기에 레시피 추가", Toast.LENGTH_SHORT).show();
            }
        });


        for(i=0;i<checkBoxID.length;i++){
            checkBox[i] = (CheckBox) findViewById(checkBoxID[i]);
        }
        shopButton = findViewById(R.id.shop1_1);

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
