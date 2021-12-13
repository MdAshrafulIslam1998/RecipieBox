package com.example.recipiebox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.recipiebox.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RecipieActivity extends AppCompatActivity {


    TextView name,srt,time,des;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipie);

        name = findViewById(R.id.profileNmae);
        srt = findViewById(R.id.profileSrt);
        time = findViewById(R.id.profiletTime);
        des = findViewById(R.id.profileDes);


        //nameput = getIntent().getExtras().getString("profile");

        user = (User) getIntent().getSerializableExtra("profile");
        setUserData();




    }

    private void setUserData(){
        name.setText(user.getResName());
        srt.setText(user.getResShrtDes());
        time.setText(user.getResTime());
        des.setText(user.getResDes());
    }
}