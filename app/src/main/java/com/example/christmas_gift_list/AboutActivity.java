package com.example.christmas_gift_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    private Button btnAboutBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        init();

        btnAboutBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(AboutActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_about, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.abAboutMain:
                Intent main = new Intent(AboutActivity.this, MainActivity.class);
                //about.putExtra("activity", "Main");
                startActivity(main);
                finish();
                return (true);

            case R.id.abAboutViewGift:
                Intent view = new Intent(AboutActivity.this, GiftsViewActivity.class);
                //about.putExtra("activity", "Main");
                startActivity(view);
                finish();
                return (true);

            case R.id.abAboutAddGift:
                Intent add = new Intent(AboutActivity.this, GiftsAddActivity.class);
                //view.putExtra("activity", "Main");
                startActivity(add);
                finish();
                return (true);

            case R.id.exit:
                finish();
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }


    private void init() {
        btnAboutBack = findViewById(R.id.btnAboutBack);
    }
}