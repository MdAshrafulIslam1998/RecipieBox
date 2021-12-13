package com.example.recipiebox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recipiebox.adapter.UserAdapter;
import com.example.recipiebox.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    UserAdapter adapter;


    SwipeRefreshLayout swipeRefreshLayout;

    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipRefresh);
        recyclerView = findViewById(R.id.recipe_list);
        floatingActionButton = findViewById(R.id.floatingActionButton);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        getUserList();


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AddRecipieActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getUserList();
                swipeRefreshLayout.setRefreshing(false);
            }
        });


    }




    private  void getUserList() {

        List<User> list = AppDatabase.getInstance(this).userDao().getAllUserList();
        adapter = new UserAdapter(this,list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onStart() {
        super.onStart();
        getUserList();
    }
}