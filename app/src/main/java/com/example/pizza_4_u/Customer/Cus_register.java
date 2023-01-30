package com.example.pizza_4_u.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pizza_4_u.Admin.SQLiteHelper;
import com.example.pizza_4_u.R;

public class Cus_register extends AppCompatActivity {

    EditText UName,Email,PW,Rpw;
    Button RegBtn;

    public static CustomerDBHelper DBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cus_register);

        UName=findViewById(R.id.txtUserName);
        Email=findViewById(R.id.txtEmail);
        PW=findViewById(R.id.txtPassword);
        Rpw=findViewById(R.id.txtR_password);

        DBHelper = new CustomerDBHelper(this, "PIZZA_4_U", null, 1);

        DBHelper.queryData("CREATE TABLE IF NOT EXISTS CUSTOMERDETAILS (Id INTEGER PRIMARY KEY AUTOINCREMENT, NAME VARCHAR, EMAIL VARCHAR, PASSWORD VARCHAR)");
    }

    public void HomeMain(View view) {
        String uname=UName.getText().toString();
        String email= Email.getText().toString();
        String pw=PW.getText().toString();
        String rpw=Rpw.getText().toString();

        if(uname.equals("")|| email.equals("")|| pw.equals("")|| rpw.equals("")){
            Toast toast = Toast.makeText(this, "Fill All the Feilds", Toast.LENGTH_SHORT);
            toast.show();
        }
        else{
            if(pw.equals(rpw)){
                Boolean checkUser= DBHelper.checkCusName(uname);
                if(checkUser == false){
                    Boolean checkinsertData = DBHelper.insertCustomerRecord(uname,email,pw);

                    if(checkinsertData == true){
                        Toast toast = Toast.makeText(this, "Data Insert Successfully", Toast.LENGTH_SHORT);
                        toast.show();
                        Intent intent=new Intent(Cus_register.this,Cus_home.class);
                        startActivity(intent);

                    }
                    else {
                        Toast toast = Toast.makeText(this, "Error", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
                else{
                    Toast toast = Toast.makeText(this, "Customer already Exists..! Please Sign In", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
            else {
                Toast toast = Toast.makeText(this, "Password Not Matched", Toast.LENGTH_SHORT);
                toast.show();
            }
        }


    }

    public void SignIn(View view) {
        startActivity(new Intent(Cus_register.this,Cus_login.class));
    }

}