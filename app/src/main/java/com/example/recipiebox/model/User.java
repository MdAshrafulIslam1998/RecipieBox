package com.example.recipiebox.model;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int resId;
    private String resName;
    private String resShrtDes;
    private String resTime;
    private String resDes;

    public User(String resName, String resShrtDes, String resTime, String resDes) {

        this.resName = resName;
        this.resShrtDes = resShrtDes;
        this.resTime = resTime;
        this.resDes = resDes;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getResName() {
        return resName;
    }

    public void setResName(String resName) {
        this.resName = resName;
    }

    public String getResShrtDes() {
        return resShrtDes;
    }

    public void setResShrtDes(String resShrtDes) {
        this.resShrtDes = resShrtDes;
    }

    public String getResTime() {
        return resTime;
    }

    public void setResTime(String resTime) {
        this.resTime = resTime;
    }

    public String getResDes() {
        return resDes;
    }

    public void setResDes(String resDes) {
        this.resDes = resDes;
    }
}
