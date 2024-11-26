package com.example.test;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Shop extends AppCompatActivity {

    private TextView selectedItemsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        selectedItemsTextView = findViewById(R.id.selected_items_text);

        // Intent로부터 데이터를 가져옴
        ArrayList<String> selectedItems = getIntent().getStringArrayListExtra("selectedItems");

        if (selectedItems != null && !selectedItems.isEmpty()) {
            StringBuilder itemsText = new StringBuilder("선택된 항목:\n");
            for (String item : selectedItems) {
                itemsText.append("- ").append(item).append("\n");
            }
            selectedItemsTextView.setText(itemsText.toString());
        } else {
            selectedItemsTextView.setText("선택된 항목이 없습니다.");
        }
    }
}
