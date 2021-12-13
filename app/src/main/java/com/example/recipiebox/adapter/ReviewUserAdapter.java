package com.example.recipiebox.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipiebox.R;
import com.example.recipiebox.RecipieActivity;
import com.example.recipiebox.UpdateActivity;
import com.example.recipiebox.model.User;

import java.util.List;

public class ReviewUserAdapter extends RecyclerView.Adapter<ReviewUserAdapter.UserViewHolder>{


    private Context context;
    private List<User> userList;


    public ReviewUserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public ReviewUserAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false);
        return new ReviewUserAdapter.UserViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ReviewUserAdapter.UserViewHolder holder,int position) {

        User user = userList.get(position);

        holder.nameE.setText(user.getResName().toString());
        holder.srtE.setText(user.getResShrtDes().toString());
        holder.timeE.setText(user.getResTime().toString());



        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("MODEL",user);
                context.startActivity(intent);




            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }




    public class UserViewHolder extends RecyclerView.ViewHolder  {

        TextView nameE,srtE,timeE,desE;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            nameE = itemView.findViewById(R.id.profiletTime);
            srtE = itemView.findViewById(R.id.txtSrt);
            timeE = itemView.findViewById(R.id.txtTime);


        }


    }
}
