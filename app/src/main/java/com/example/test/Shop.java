package com.example.test;

import java.util.ArrayList;

public class Shop {

    private static Shop instance;
    private ArrayList<String> selectedItems = new ArrayList<>();

    private Shop() {}

    public static synchronized Shop getInstance() {
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }

    // 데이터 업데이트
    public void updateData(ArrayList<String> items) {
        this.selectedItems = new ArrayList<>(items); // 새로운 데이터로 갱신
    }

    // 선택된 항목 가져오기
    public ArrayList<String> getSelectedItems() {
        return selectedItems;
    }

    // 선택된 항목 삭제
    public void deleteSelectedItems(ArrayList<Integer> positionsToDelete) {
        ArrayList<String> updatedItems = new ArrayList<>();
        for (int i = 0; i < selectedItems.size(); i++) {
            if (!positionsToDelete.contains(i)) {
                updatedItems.add(selectedItems.get(i));
            }
        }
        this.selectedItems = updatedItems; // 삭제 후 리스트 갱신
    }
}
