package com.example.wepartyallnight;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class User {
    private int id;
    private String name;
    private String phone;
    private Date createdAt;
    private Date updatedAt;

    public User(JSONObject data) {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        try {
            this.id = data.getInt("id");
            this.name = data.getString("name");
            this.phone = data.getString("phone");
            try {
                this.createdAt = formatter.parse(data.getString("createdAt"));
                this.updatedAt = formatter.parse(data.getString("updatedAt"));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
