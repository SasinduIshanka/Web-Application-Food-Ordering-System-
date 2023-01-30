package com.example.pizza_4_u.Cus_Cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pizza_4_u.Admin.SQLiteHelper;
import com.example.pizza_4_u.Cus_Menu.CusFood;
import com.example.pizza_4_u.Customer.FoodAdapter;
import com.example.pizza_4_u.R;

import java.util.ArrayList;

public class Cart_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<CartItemModel> dataholder;
    TextView tot;

    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart2);

        sqLiteHelper = new SQLiteHelper(this, "PIZZA_4_U", null, 1);

        recyclerView=(RecyclerView)findViewById(R.id.recview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Cursor cursor=sqLiteHelper.GetDataToCart();
        dataholder=new ArrayList<>();

        while(cursor.moveToNext())
        {
            CartItemModel obj=new CartItemModel(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4));
            dataholder.add(obj);
        }

        CartAdapter adapterN=new CartAdapter(dataholder);
        recyclerView.setAdapter(adapterN);
    }

    public void Clear(View view) {
        sqLiteHelper.DeleteData();

        sqLiteHelper = new SQLiteHelper(this, "PIZZA_4_U", null, 1);

        recyclerView=(RecyclerView)findViewById(R.id.recview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=sqLiteHelper.GetDataToCart();
        dataholder=new ArrayList<>();

        while(cursor.moveToNext())
        {
            CartItemModel obj=new CartItemModel(cursor.getInt(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3),cursor.getInt(4));
            dataholder.add(obj);
        }

        CartAdapter adapterN=new CartAdapter(dataholder);
        recyclerView.setAdapter(adapterN);
    }
}