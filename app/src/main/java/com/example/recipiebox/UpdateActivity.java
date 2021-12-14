package com.example.recipiebox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recipiebox.model.User;

import java.net.UnknownServiceException;

public class UpdateActivity extends AppCompatActivity {


    Button delbtnp;
    EditText nameEdtp,srtEdtp,timeEdtp,desEdtp;
    User user,user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        nameEdtp = findViewById(R.id.UpdaterecipieNamep);
        srtEdtp = findViewById(R.id.UpdaterecipiesrtDesp);
        timeEdtp  = findViewById(R.id.UpdaterecipieTimep);
        desEdtp  = findViewById(R.id.UpdaterecipieDesp);
        delbtnp = findViewById(R.id.idBtnSaveRecipieDeletep);

        if(getIntent()!=null){
            user = (User) getIntent().getSerializableExtra("MODEL");
            setUserData();
        }


        delbtnp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AppDatabase.getInstance(UpdateActivity.this).userDao().deleteUser(user);
                Toast.makeText(getApplicationContext(), "Deleted", Toast.LENGTH_SHORT).show();

            }
        });




    }


    private void setUserData(){
        nameEdtp.setText(user.getResName());
        srtEdtp.setText(user.getResShrtDes());
        timeEdtp.setText(user.getResTime());
        desEdtp.setText(user.getResDes());
    }

}