package com.example.pizza_4_u;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pizza_4_u.Admin.Admin_login;
import com.example.pizza_4_u.Customer.Cus_login;
import com.example.pizza_4_u.Customer.Cus_register;

public class MainActivity extends AppCompatActivity {

    Button btnREG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnREG=findViewById(R.id.btnRegis);
        btnREG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, Cus_register.class);
                startActivity(intent);
                System.out.println("done");
            }
        });

    }

    public void Login(View view) {
        Intent intent=new Intent(MainActivity.this, Cus_login.class);
        startActivity(intent);
        System.out.println("done");
    }

    public void Admin(View view) {
        Intent intent=new Intent(MainActivity.this, Admin_login.class);
        startActivity(intent);
    }
}