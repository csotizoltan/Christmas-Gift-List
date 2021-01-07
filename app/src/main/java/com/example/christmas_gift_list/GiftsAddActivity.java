package com.example.christmas_gift_list;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class GiftsAddActivity extends AppCompatActivity {

    private EditText etAddPerson, etAddGift, etAddGiftNotes;
    //private CheckBox cbBought;
    private Button btnAddGift, btnAddBack;

    private DBhelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gifts_add);

        init();

        btnAddGift.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDatabase();
            }
        });

        btnAddBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(GiftsAddActivity.this, MainActivity.class);
                startActivity(back);
                finish();
            }
        });
    }


    private void addDatabase() {
        String person = etAddPerson.getText().toString().trim();
        String gift = etAddGift.getText().toString().trim();
        String gift_notes = etAddGiftNotes.getText().toString().trim();

        String bought = null;

        /*if (cbBought.isChecked()) {
            bought = "yes";
        }
        else {
            bought = "no";
        }*/

        if (database.dataInsert(person, gift, gift_notes, bought)) {
            Toast.makeText(this, "Sikeres rögzítés", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Sikertelen rögzítés", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.abAddMain:
                Intent main = new Intent(GiftsAddActivity.this, MainActivity.class);
                //about.putExtra("activity", "Main");
                startActivity(main);
                finish();
                return (true);

            case R.id.abAddViewGift:
                Intent view = new Intent(GiftsAddActivity.this, GiftsViewActivity.class);
                //view.putExtra("activity", "Main");
                startActivity(view);
                finish();
                return (true);

            case R.id.abAddAbout:
                Intent about = new Intent(GiftsAddActivity.this, AboutActivity.class);
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
        etAddPerson = findViewById(R.id.etAddPerson);
        etAddGift = findViewById(R.id.etAddGift);
        etAddGiftNotes = findViewById(R.id.etAddGiftNotes);
        //cbBought = findViewById(R.id.cbBought);
        btnAddGift = findViewById(R.id.btnAddGift);
        btnAddBack = findViewById(R.id.btnAddBack);

        database = new DBhelper(GiftsAddActivity.this);
    }
}