package com.example.pizza_4_u.Customer;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class CustomerDBHelper extends SQLiteOpenHelper{

    public CustomerDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Boolean insertCustomerRecord(String name,String email,String pw){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cus= new ContentValues();
        //data
        cus.put("NAME",name);
        cus.put("EMAIL",email);
        cus.put("PASSWORD",pw);

        //insert method
        long result= db.insert("CUSTOMERDETAILS",null,cus);

        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public Boolean checkCusName(String un){
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery("select * from CUSTOMERDETAILS where EMAIL =? ",new String[]{un});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }

    }

    public Boolean checkUserNamePassword(String email,String pw){
        SQLiteDatabase db=this.getWritableDatabase();

        Cursor cursor=db.rawQuery("select * from CUSTOMERDETAILS where EMAIL=? AND PASSWORD =? ",new String[]{email,pw});
        if(cursor.getCount()>0){
            return true;
        }
        else {
            return false;
        }

    }

    public Boolean insertCartItem(String name,int price,int qty,int q_total){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cus= new ContentValues();
        //data
        cus.put("NAME",name);
        cus.put("PRICE",price);
        cus.put("QUANTITY",qty);
        cus.put("Q_TOTAL",q_total);

        //insert method
        long result= db.insert("CART",null,cus);

        if(result == -1){
            return false;
        }
        else {
            return true;
        }
    }
}
