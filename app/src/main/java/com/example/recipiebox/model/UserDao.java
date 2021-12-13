package com.example.recipiebox.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from user")
    public List<User> getAllUserList();

    @Insert
    long insertUser(User user);

    @Update
    void updateUser(User user);

    @Delete
    public void deleteUser(User user);

}
