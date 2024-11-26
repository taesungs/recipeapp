package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ShopAdapter adapter;
    private Button deleteSelectedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop);

        recyclerView = findViewById(R.id.recycler_view_shop);
        deleteSelectedButton = findViewById(R.id.button_delete_selected);

        // Shop 클래스에서 전달받은 데이터 가져오기
        ArrayList<String> selectedItems = Shop.getInstance().getSelectedItems();

        // RecyclerView 설정
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ShopAdapter(selectedItems);
        recyclerView.setAdapter(adapter);

        // 삭제 버튼 클릭 이벤트
        deleteSelectedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer> positionsToDelete = adapter.getSelectedItemPositions();
                Shop.getInstance().deleteSelectedItems(positionsToDelete); // Shop에 데이터 갱신
                adapter = new ShopAdapter(Shop.getInstance().getSelectedItems()); // 어댑터 갱신
                recyclerView.setAdapter(adapter); // RecyclerView 갱신
            }
        });
    }
}
