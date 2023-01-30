package com.example.pizza_4_u.Cus_Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizza_4_u.Admin.Food;
import com.example.pizza_4_u.Admin.SQLiteHelper;
import com.example.pizza_4_u.Cus_Cart.Cart_Activity;
import com.example.pizza_4_u.Customer.Cus_home;
import com.example.pizza_4_u.Customer.Cus_register;
import com.example.pizza_4_u.Customer.CustomerDBHelper;
import com.example.pizza_4_u.R;

public class FoodItemInfo extends AppCompatActivity {

    TextView FName,Fprice,total;
    SQLiteHelper helper;
    ImageView imageView;
    ImageButton plusquantity, minusquantity;
    TextView quantitynumber;
    int quantity;
    int Item_Total,Nprice,qt,qTot;
    String name,price;

    public static CustomerDBHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_info);

        DBHelper = new CustomerDBHelper(this, "PIZZA_4_U", null, 1);

        DBHelper.queryData("CREATE TABLE IF NOT EXISTS CART (Id INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR, PRICE INTEGER, QUANTITY INTEGER,Q_TOTAL INTEGER)");

        FName=(TextView) findViewById(R.id.txtnameView);
        Fprice=(TextView)findViewById(R.id.txtpriceView);
        plusquantity = (ImageButton) findViewById(R.id.addquantity);
        minusquantity  = (ImageButton) findViewById(R.id.subquantity);
        quantitynumber = (TextView) findViewById(R.id.quantity);
        total=(TextView) findViewById(R.id.txtTotalQ);
        name=getIntent().getStringExtra("name");
        price=getIntent().getStringExtra("price");
       FName.setText(name);
       Fprice.setText(price);


        plusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                quantitynumber.setText(String.valueOf(quantity));
                CalTotal();

            }
        });

        minusquantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int basePrice = 5;
                // because we dont want the quantity go less than 0
                if (quantity == 0) {
                    Toast.makeText(FoodItemInfo.this, "Cant decrease quantity < 0", Toast.LENGTH_SHORT).show();
                } else {
                    quantity--;
                    quantitynumber.setText(String.valueOf(quantity));
                    CalTotal();

                }
            }
        });
    }

    private void CalTotal() {
        int priceI=Integer.parseInt(Fprice.getText().toString());
        int Q=Integer.parseInt(quantitynumber.getText().toString());
        Item_Total=Q*priceI;
        total.setText(String.valueOf(Item_Total));
    }

    public void AddToCart(View view) {

        name=FName.getText().toString();
        Nprice=Integer.parseInt(Fprice.getText().toString());
        qt=Integer.parseInt(quantitynumber.getText().toString());
        qTot=Integer.parseInt(total.getText().toString());

        Boolean checkinsertData = DBHelper.insertCartItem(name,Nprice,qt,qTot);

        if(checkinsertData == true){
            Toast toast = Toast.makeText(this, "Item Added to cart Successfully", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent=new Intent(FoodItemInfo.this, Cart_Activity.class);
            startActivity(intent);

        }
        else {
            Toast toast = Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}