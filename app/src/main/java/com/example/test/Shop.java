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

    // 데이터 추가
    public void addData(ArrayList<String> items) {
        if (items != null && !items.isEmpty()) {
            selectedItems.addAll(items); // 기존 데이터에 추가
        }
    }

    // 데이터 갱신 (새로운 데이터로 교체)
    public void updateData(ArrayList<String> items) {
        this.selectedItems = new ArrayList<>(items);
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
        this.selectedItems = updatedItems;
    }
}
