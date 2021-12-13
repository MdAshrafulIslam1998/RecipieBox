package com.example.recipiebox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recipiebox.model.User;

public class AddRecipieActivity extends AppCompatActivity {


    Button btn,revBtn;
    EditText nameEdt,srtEdt,timeEdt,desEdt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipie);

        nameEdt = findViewById(R.id.recipieName);
        srtEdt = findViewById(R.id.recipiesrtDes);
        timeEdt  = findViewById(R.id.recipieTime);
        desEdt  = findViewById(R.id.recipieDes);
        btn = findViewById(R.id.idBtnSaveRecipie);
        revBtn = findViewById(R.id.reviewBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= nameEdt.getText().toString();
                String srt= srtEdt.getText().toString();
                String time= timeEdt.getText().toString();
                String des= desEdt.getText().toString();


                User user = new User(name,srt,time,des);
                long response = AppDatabase.getInstance(AddRecipieActivity.this).userDao().insertUser(user);

                if(response>0){
                    Toast.makeText(getApplicationContext(), "Record inserted", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }




            }
        });

        revBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(AddRecipieActivity.this, ReviewActivity.class);
                AddRecipieActivity.this.startActivity(myIntent);
            }
        });
    }
}