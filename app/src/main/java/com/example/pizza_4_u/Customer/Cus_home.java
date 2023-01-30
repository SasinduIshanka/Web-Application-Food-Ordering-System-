package com.example.pizza_4_u.Customer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizza_4_u.Cus_Cart.Cart_Activity;
import com.example.pizza_4_u.Cus_Menu.CusMenuFetch;
import com.example.pizza_4_u.R;

public class Cus_home extends AppCompatActivity {


    private RecyclerView.Adapter RCcat_A,RCpop_A;
    private RecyclerView RCcat,RCpop;

    DrawerLayout drawerLayout;
    CustomerDBHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_home);

        drawerLayout=findViewById(R.id.drawer);
    }


    public  void ClickMenu(View view){
        openDrawer(drawerLayout);
    }

    public static void openDrawer(DrawerLayout drawerLayout) {

        drawerLayout.openDrawer(GravityCompat.START);

    }
    public void ClickLogo(View view){
        closeDrawer(drawerLayout);
    }

    public static void closeDrawer(DrawerLayout drawerLayout) {

        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);

        }

    }
    public void Clickhome(View view){
        recreate();

    }

    public  void clickMenu(View view){
        redirectActivity(this, CusMenuFetch.class);



    }
    public  void clickAboutUs(View view){
        //redirectActivity(this,AboutUs.class);
    }

    public  void ViewCart(View view){
        redirectActivity(this, Cart_Activity.class);
    }

    public  void ClickLogout(View view){
        logout(this);
    }

    public static void logout(Activity activity) {
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        builder.setTitle("Logout");
        builder.setMessage("Are you sure you want to logout?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.finishAffinity();
                System.exit(0);
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();



    }

    public   static void redirectActivity(Activity activity,Class Class) {
        Intent intent=new Intent(activity,Class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);

    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }

    public void Deals(View view) {
        startActivity(new Intent(Cus_home.this,CusMenuFetch.class));
    }
}