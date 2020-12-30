package com.example.christmas_gift_list;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GiftsViewActivity extends AppCompatActivity {

    private Button btnViewBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifts_view);

        init();

        btnViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(GiftsViewActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }


    private void init() {
        btnViewBack = findViewById(R.id.btnViewBack);
    }
}