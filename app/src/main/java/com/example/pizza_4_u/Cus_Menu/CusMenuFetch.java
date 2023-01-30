package com.example.pizza_4_u.Cus_Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.example.pizza_4_u.Admin.SQLiteHelper;
import com.example.pizza_4_u.Customer.FoodAdapter;
import com.example.pizza_4_u.R;

import java.util.ArrayList;

public class CusMenuFetch extends AppCompatActivity implements RecyclerViewInterface {

    RecyclerView recyclerView;
    ArrayList<CusFood> dataholder;

    public static SQLiteHelper sqLiteHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_menu_fetch);

        sqLiteHelper = new SQLiteHelper(this, "PIZZA_4_U", null, 1);

        recyclerView=(RecyclerView)findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor=sqLiteHelper.GetDataToMenu();
        dataholder=new ArrayList<>();

        while(cursor.moveToNext())
        {
            CusFood obj=new CusFood(cursor.getString(1),cursor.getString(2),cursor.getBlob(3));
            dataholder.add(obj);
        }

        FoodAdapter adapterN=new FoodAdapter(dataholder,this);
        recyclerView.setAdapter(adapterN);



    }

    @Override
    public void onItemClick(int position) {
        Intent intent=new Intent(CusMenuFetch.this,FoodItemInfo.class);

        intent.putExtra("name",dataholder.get(position).getName());
        intent.putExtra("price",dataholder.get(position).getPrice());
        startActivity(intent);

    }
}