package com.example.test;

import java.util.ArrayList;

public class Shop {

    private static Shop instance;
    private ArrayList<String> selectedItems = new ArrayList<>();

    private Shop() {    // 생성자를 private로 선언**
    }

    public static synchronized Shop getInstance() { // 싱글턴객체(오직하나) 가져오는 메소드
        if (instance == null) {
            instance = new Shop();
        }
        return instance;
    }


    // 데이터 추가
    public void addData(ArrayList<String> items) {
        if (items != null && !items.isEmpty()) {    // 선택된 것들이 존재하면 실행
            selectedItems.addAll(items); // 기존 데이터에 추가
        }
    }

    // 선택된 항목 가져오기
    public ArrayList<String> getSelectedItems() {
        return selectedItems;
    }

    // 선택된 항목 삭제
    public void deleteSelectedItems(ArrayList<Integer> positionsToDelete) { // 인덱스리스트를 인수로 받음
        ArrayList<String> updatedItems = new ArrayList<>();
        for (int i = 0; i < selectedItems.size(); i++) {    // 여기서는 selectedItems 는 쇼핑카트에서 삭제하려고 선택한 항목list
            if (!positionsToDelete.contains(i)) {   // 인덱스i 가 인덱스리스트에 '없다면', i번째 항목을 updatedItems 리스트에 추가
                updatedItems.add(selectedItems.get(i));
            }
        }
        this.selectedItems = updatedItems;  // 항목list 없데이트
    }


}