package com.example.pizza_4_u.Cus_Menu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FoodInfoSqliteHelper extends SQLiteOpenHelper {
    private static final String DB_Name="";
    private static final int DB_Version=1;

    public FoodInfoSqliteHelper(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
