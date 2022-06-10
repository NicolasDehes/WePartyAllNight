package com.example.wepartyallnight;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Event {

    private String name;
    private String description;
    private Date date_event;
    private String adress;
    private double lat;
    private double lng;
    private int createdBy;
    private User user;
    private Date createdAt;
    private Date updatedAt;

    public Event(){}

    public Event(JSONObject data) {
        DateFormat formatter = new SimpleDateFormat("yyyy-M-d'T'HH:mm:ss");
        try {
            this.name = data.getString("name");
            this.adress = data.getString("adress");
            this.description = data.getString("description");
            try {
                String temp = data.getString("date_event").substring(0,data.getString("date_event").length()-5);
                this.date_event = formatter.parse(temp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            this.lat = data.getDouble("lat");
            this.lng = data.getDouble("lng");
            if(data.has("User")){
                this.user = new User(data.getJSONObject("User"));
            }
            try {
                String temp = data.getString("createdAt").substring(0,data.getString("createdAt").length()-5);
                this.createdAt = formatter.parse(temp);
                temp = data.getString("updatedAt").substring(0,data.getString("updatedAt").length()-5);
                this.updatedAt = formatter.parse(temp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Date getDateEvent() {
        return date_event;
    }
    public String getAdress() {
        return adress;
    }
    public double getLat() {
        return lat;
    }
    public double getLng() {
        return lng;
    }
    public int getCreatedBy() {
        return createdBy;
    }
    public User getUser() {
        return user;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setDateEvent(Date dateEvent) {
        this.date_event = dateEvent;
    }
    public void setAdress(String adress) {
        this.adress = adress;
    }
    public void setLat(float lat) {
        this.lat = lat;
    }
    public void setLng(float lng) {
        this.lng = lng;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
