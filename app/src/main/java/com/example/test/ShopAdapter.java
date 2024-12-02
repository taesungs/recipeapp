package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    private ArrayList<String> itemList;
    private ArrayList<Boolean> itemCheckedList; // 체크 상태를 저장

    public ShopAdapter(ArrayList<String> itemList) {
        this.itemList = itemList;
        this.itemCheckedList = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++) {
            itemCheckedList.add(false); // 기본적으로 모두 '선택해제'된 상태
        }
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shop_checkbox, parent, false);
        return new ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        String item = itemList.get(position);
        holder.checkBox.setText(item);
        holder.checkBox.setChecked(itemCheckedList.get(position));

        // 체크박스 상태 변경 이벤트
        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            itemCheckedList.set(holder.getAdapterPosition(), isChecked);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // 삭제할 항목의 '인덱스'를 담은 리스트 반환
    public ArrayList<Integer> getSelectedItemPositions() {
        ArrayList<Integer> positions = new ArrayList<>();
        for (int i = 0; i < itemCheckedList.size(); i++) {
            if (itemCheckedList.get(i)) { // 체크된 항목만 추가
                positions.add(i);
            }
        }
        return positions;
    }

    public static class ShopViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;

        public ShopViewHolder(@NonNull View itemView) { // 체크박스 위젯 연결
            super(itemView);
            checkBox = itemView.findViewById(R.id.checkbox_item);
        }
    }

    public void updateItemList(ArrayList<String> newItems) {
        this.itemList.addAll(newItems); // 기존 리스트에 추가
        for (int i = 0; i < newItems.size(); i++) {
            itemCheckedList.add(false); // 새로 추가된 항목의 체크 상태 초기화
        }
        notifyDataSetChanged(); // RecyclerView 업데이트
    }





}
