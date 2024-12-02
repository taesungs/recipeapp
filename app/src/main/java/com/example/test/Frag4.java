package com.example.test;


import static android.app.Activity.RESULT_OK;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;
import java.util.Random;

public class Frag4 extends Fragment {

    private View view, dialogView;
    EditText edtnewid, edtnewtext;
    ImageButton imgButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag4, container, false);

        Button shopButton = view.findViewById(R.id.shop);
        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ShopActivity.class);
                startActivity(intent);
            }
        });

        Button ratingButton = view.findViewById(R.id.rating);
        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Rating.class);
                startActivity(intent);
            }
        });

        Button favorButton = view.findViewById(R.id.favor);
        favorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Favor.class);
                startActivity(intent);
            }
        });


        Button idButton = view.findViewById(R.id.idButton);

        // 기존 텍스트 가져오기
        String currentText = idButton.getText().toString();

        // 랜덤 숫자 생성 (0부터 100000 사이의 숫자)
        Random random = new Random();
        int randomNumber = random.nextInt(100000); // 0~99999

        // 기존 텍스트에 랜덤 숫자를 추가
        String newText = currentText + "@" + randomNumber;

        // 버튼 텍스트 업데이트
        idButton.setText(newText);

        idButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(getContext(), R.layout.id_dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());

                edtnewid = (EditText) dialogView.findViewById(R.id.edtnewid);
                edtnewid.setText(idButton.getText().toString().substring(5));

                dlg.setTitle("ID를 수정하세요")
                        .setIcon(R.drawable.idrename)
                        .setView(dialogView)
                        .setPositiveButton("수정", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (edtnewid.getText().toString().isEmpty()) {
                                    Toast.makeText(getContext(), "아이디를 입력하세요", Toast.LENGTH_SHORT).show();
                                } else {
                                    idButton.setText("아이디: " + edtnewid.getText().toString());
                                }
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "아이디변경을 취소했습니다", Toast.LENGTH_SHORT).show();
                            }
                        });

                dlg.show();
            }
        });

        Button Textbtn = (Button) view.findViewById(R.id.edtTextbtn);

        Textbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(getContext(), R.layout.text_dialog, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(getContext());

                edtnewtext = (EditText) dialogView.findViewById(R.id.edtnewid);
                edtnewtext.setText(Textbtn.getText().toString());

                dlg.setTitle("소개글을 수정하세요")
                        .setIcon(R.drawable.idrename)
                        .setView(dialogView)
                        .setPositiveButton("수정", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                if (edtnewtext.getText().toString().isEmpty()) {
                                    Toast.makeText(getContext(), "소개글을 입력하세요", Toast.LENGTH_SHORT).show();
                                } else {
                                    Textbtn.setText(edtnewtext.getText().toString());
                                }
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getContext(), "소개글변경을 취소했습니다", Toast.LENGTH_SHORT).show();
                            }
                        });

                dlg.show();
            }
        });

        imgButton = (ImageButton) view.findViewById(R.id.imgButton);
        imgButton.setImageResource(R.drawable.person_icon);
        imgButton.setOnClickListener(view -> openGallery());

        return view;
    }

    // Activity Result Launcher를 사용하여 갤러리에서 이미지 선택
    private final ActivityResultLauncher<Intent> galleryLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    Uri selectedImageUri = result.getData().getData(); // 선택된 이미지 URI 가져오기
                    if (selectedImageUri != null) {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImageUri);
                            imgButton.setImageBitmap(bitmap);
                        } catch (IOException e) {   // 예외처리 코드
                            e.printStackTrace();
                            Toast.makeText(getContext(), "이미지를 불러올 수 없습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
    );

    // 갤러리 열기
    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        galleryLauncher.launch(intent);
    }
}