package com.example.wepartyallnight;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Invitation {
    private String userPhone;
    private int eventId;
    private Event event;
    private String status;
    private Date createdAt;
    private Date updatedAt;

    public Invitation(){}

    public Invitation(JSONObject data){
        DateFormat formatter = new SimpleDateFormat("yyyy-M-d'T'HH:mm:ss");
        try {
            this.userPhone = data.getString("userPhone");
            this.eventId = data.getInt("eventId");
            this.status = data.getString("status");
            try {
                String temp = data.getString("createdAt").substring(0,data.getString("createdAt").length()-5);
                this.createdAt = formatter.parse(temp);
                temp = data.getString("updatedAt").substring(0,data.getString("updatedAt").length()-5);
                this.updatedAt = formatter.parse(temp);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if(data.has("Event")){
                this.event = new Event(data.getJSONObject("Event"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getUserPhone() {
        return userPhone;
    }
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
    public int getEventId() {
        return eventId;
    }
    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
    public Event getEvent() {
        return event;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
