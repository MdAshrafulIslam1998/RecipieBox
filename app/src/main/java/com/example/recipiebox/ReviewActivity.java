package com.example.recipiebox;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.recipiebox.adapter.ReviewUserAdapter;
import com.example.recipiebox.adapter.UserAdapter;
import com.example.recipiebox.model.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class ReviewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ReviewUserAdapter adapter;


    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        swipeRefreshLayout = findViewById(R.id.swipRefresh);
        recyclerView = findViewById(R.id.recipe_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        getUserList();




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
        adapter = new ReviewUserAdapter(this,list);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    protected void onStart() {
        super.onStart();
        getUserList();
    }
}