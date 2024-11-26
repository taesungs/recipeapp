package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Menu1_1 extends AppCompatActivity {

    private CheckBox[] checkBox = new CheckBox[3];
    Integer[] checkboxID = {R.id.item1_1_1, R.id.item1_1_2, R.id.item1_1_3};
    private Button shopButton;
    private TextView resultTextView;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu1_1);


        for (i=0; i< checkboxID.length; i++){
        checkBox[i] = (CheckBox) findViewById(checkboxID[i]);}

        shopButton = findViewById(R.id.shop1_1);
        resultTextView = findViewById(R.id.result_text); // 선택 결과를 표시할 TextView

        shopButton.setOnClickListener(new View.OnClickListener() {
            Intent intent = new Intent();

            for(i = 0;i< checkboxID.length;i++)

            {

                if (checkBox[i].isChecked()) {
                    intent.putExtra("item", checkBox[i].getText().toString());
                    break;
                }else
//                }
//                // 데이터를 처리하는 메서드 호출
//                handleIntentData(intent);

                }

            }

    }



//            @Override
//            public void onClick(View v) {
//                ArrayList<String> selectedItems = new ArrayList<>();
//
//                if (checkBox1.isChecked()) {
//                    selectedItems.add(checkBox1.getText().toString());
//                }
//                if (checkBox2.isChecked()) {
//                    selectedItems.add(checkBox2.getText().toString());
//                }
//                if (checkBox3.isChecked()) {
//                    selectedItems.add(checkBox3.getText().toString());
//                }

                // Intent에 데이터 추가
//                Intent intent = new Intent();
//                for (int i=0;i<) {
//                    intent.putStringArrayListExtra("selectedItems", selectedItems);
//                }
//                // 데이터를 처리하는 메서드 호출
//                handleIntentData(intent);
//            }
//        });
//    }
//
//    // 데이터를 처리하는 메서드
//    private void handleIntentData(Intent intent) {
//        ArrayList<String> selectedItems = intent.getStringArrayListExtra("selectedItems");
//
//        if (selectedItems != null && !selectedItems.isEmpty()) {
//            StringBuilder itemsText = new StringBuilder("선택된 항목:\n");
//            for (String item : selectedItems) {
//                itemsText.append("- ").append(item).append("\n");
//            }
//            resultTextView.setText(itemsText.toString());
//        } else {
//            resultTextView.setText("선택된 항목이 없습니다.");
//        }
//    }
//}
