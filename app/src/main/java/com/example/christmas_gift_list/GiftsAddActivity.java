package com.example.christmas_gift_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GiftsAddActivity extends AppCompatActivity {

    private Button btnAddBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifts_add);

        init();

        btnAddBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(GiftsAddActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }


    private void init() {
        btnAddBack = findViewById(R.id.btnAddBack);
    }
}