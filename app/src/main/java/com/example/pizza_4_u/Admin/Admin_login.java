package com.example.pizza_4_u.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pizza_4_u.R;

public class Admin_login extends AppCompatActivity {

    EditText unA,pwA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        unA=findViewById(R.id.txtUserNameLA);
        pwA=findViewById(R.id.txtPasswordLA);


    }

    public void SignIn(View view) {
        String un=unA.getText().toString();
        String pw=pwA.getText().toString();

        if(un.equals("")|| pw.equals("")){
            Toast toast = Toast.makeText(this, "Fill All the Feilds", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            if(un.equals("shashi") && pw.equals("4444")){
                Toast toast = Toast.makeText(this, "Successfully Logged In..!", Toast.LENGTH_SHORT);
                toast.show();
                startActivity(new Intent(Admin_login.this,Admin_home.class));
            }
            else{
                Toast toast = Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}