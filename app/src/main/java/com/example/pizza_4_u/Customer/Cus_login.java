package com.example.pizza_4_u.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pizza_4_u.R;

public class Cus_login extends AppCompatActivity {

    EditText Email,Pw;
    Button btnLogin;
    public static CustomerDBHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_login);

        Email=findViewById(R.id.txtEmailL);
        Pw=findViewById(R.id.txtPasswordL);
        btnLogin=findViewById(R.id.btnSignInL);

        DBHelper = new CustomerDBHelper(this, "PIZZA_4_U", null, 1);
    }

    public void SignIn(View view) {
        String email= Email.getText().toString();
        String pw=Pw.getText().toString();

        if(email.equals("")|| pw.equals("")){
            Toast toast = Toast.makeText(this, "Fill All the Feilds", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Boolean checkuser=DBHelper.checkUserNamePassword(email,pw);
            if(checkuser== true){
                Toast toast = Toast.makeText(this, "Sign In Successfull..!", Toast.LENGTH_SHORT);
                toast.show();
                startActivity(new Intent(Cus_login.this,Cus_home.class));
            }
            else {
                Toast toast = Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT);
                toast.show();
            }
        }


    }

    /*public void AdminSignIn(View view) {
        String email= Email.getText().toString();
        String pw=Pw.getText().toString();

        if(email.equals("")|| pw.equals("")){
            Toast toast = Toast.makeText(this, "Fill All the Feilds", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            Boolean checkuser=DBHelper.checkUserNamePassword(email,pw);
            if(checkuser== true){
                Toast toast = Toast.makeText(this, "Sign In Successfull..!", Toast.LENGTH_SHORT);
                toast.show();
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }
            else {
                Toast toast = Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT);
                toast.show();
            }
        }


    }*/

    public void Register(View view) {
        startActivity(new Intent(Cus_login.this,Cus_register.class));
    }
}