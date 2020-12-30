package com.example.christmas_gift_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnView, btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view = new Intent(MainActivity.this, GiftsViewActivity.class);
                startActivity(view);
                finish();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(MainActivity.this, GiftsAddActivity.class);
                startActivity(add);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.abViewGift:
                Intent view = new Intent(MainActivity.this, GiftsViewActivity.class);
                //about.putExtra("activity", "Main");
                startActivity(view);
                finish();
                return (true);

            case R.id.abAddGift:
                Intent add = new Intent(MainActivity.this, GiftsAddActivity.class);
                //view.putExtra("activity", "Main");
                startActivity(add);
                finish();
                return (true);

            case R.id.abAbout:
                Intent about = new Intent(MainActivity.this, AboutActivity.class);
                //about.putExtra("activity", "Main");
                startActivity(about);
                finish();
                return (true);

            case R.id.exit:
                finish();
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        btnView = findViewById(R.id.btnView);
        btnAdd = findViewById(R.id.btnAdd);
    }
}