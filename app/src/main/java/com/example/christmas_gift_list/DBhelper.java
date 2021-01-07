package com.example.christmas_gift_list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "christmasgift.db";
    public static final int DB_VERSION = 1;

    public static final String CHRISTMASGIFT_TABLE = "christmasgift";
    public static final String COL_ID           = "id";
    public static final String COL_PERSON       = "person";
    public static final String COL_GIFT         = "gift";
    public static final String COL_GIFT_NOTES   = "gift_notes";
    public static final String COL_BOUGHT       = "bought";


    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql  = "CREATE TABLE IF NOT EXISTS "+CHRISTMASGIFT_TABLE+" (" +
                COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_PERSON+" VARCHAR(255) NOT NULL, " +
                COL_GIFT+" VARCHAR(255) NOT NULL, " +
                COL_GIFT_NOTES+" INTEGER NOT NULL, " +
                COL_BOUGHT+" INTEGER NOT NULL, " +
                "UNIQUE (" + COL_PERSON + "," + COL_GIFT + ")" +
                ")";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + CHRISTMASGIFT_TABLE;
        db.execSQL(sql);
        onCreate(db);
    }


    public boolean dataInsert(String person, String gift, String gift_notes, String bought) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_PERSON, person);
        values.put(COL_GIFT, gift);
        values.put(COL_GIFT_NOTES, gift_notes);
        values.put(COL_BOUGHT, bought);
        return db.insert(CHRISTMASGIFT_TABLE, null, values) != -1;
    }


    public Cursor adatLekerdezes() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(CHRISTMASGIFT_TABLE, new String[]{COL_ID, COL_PERSON, COL_GIFT, COL_GIFT_NOTES, COL_BOUGHT}, null, null,
                null, null, null);
    }


    public Cursor adatKereses(String personSearchInput, String giftSearchInput) {
        SQLiteDatabase db = this.getReadableDatabase();
        String where = "person = ? and gift = ?";
        String[] whereArgs = {personSearchInput, giftSearchInput};

        return db.query(CHRISTMASGIFT_TABLE, new String[]{COL_ID, COL_PERSON, COL_GIFT, COL_GIFT_NOTES, COL_BOUGHT}, where, whereArgs,
                null, null, null);
    }
}
