package com.example.christmas_gift_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class GiftsViewActivity extends AppCompatActivity {

    private Button btnViewBack;
    private TextView tvViewGift;

    private DBhelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifts_view);

        init();
        giftList();

        btnViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(GiftsViewActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }


    private void giftList() {
        Cursor gifts = database.adatLekerdezes();

        if (gifts == null) {
            Toast.makeText(this, "Hiba történt a lekérdezés során!", Toast.LENGTH_SHORT).show();
            return;
        }

        if (gifts.getCount() == 0) {
            Toast.makeText(this, "Még nincs felvéve adat!", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder builder = new StringBuilder();
        while (gifts.moveToNext()) {
            //builder.append("ID: ").append(gifts.getInt(0)).append("\n");
            builder.append("Kinek: ").append(gifts.getString(1)).append("\n");
            builder.append("Ajándék: ").append(gifts.getString(2)).append("\n");
            builder.append("Megjegyzés: ").append(gifts.getString(3)).append("\n\n");
            //builder.append("Megvásároltam / elkészítettem: ").append(gifts.getString(4)).append("\n\n");

            tvViewGift.setText(builder.toString());
            //Toast.makeText(this, "Sikeres adatlekérdezés", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.abViewMain:
                Intent main = new Intent(GiftsViewActivity.this, MainActivity.class);
                //about.putExtra("activity", "Main");
                startActivity(main);
                finish();
                return (true);

            case R.id.abViewAddGift:
                Intent add = new Intent(GiftsViewActivity.this, GiftsAddActivity.class);
                //view.putExtra("activity", "Main");
                startActivity(add);
                finish();
                return (true);

            case R.id.abViewbout:
                Intent about = new Intent(GiftsViewActivity.this, AboutActivity.class);
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
        btnViewBack = findViewById(R.id.btnViewBack);
        tvViewGift = findViewById(R.id.tvViewGift);

        tvViewGift.setMovementMethod(new ScrollingMovementMethod());

        database = new DBhelper(GiftsViewActivity.this);
    }
}