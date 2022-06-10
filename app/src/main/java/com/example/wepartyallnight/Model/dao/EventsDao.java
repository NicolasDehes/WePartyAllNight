package com.example.wepartyallnight.Model.dao;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.wepartyallnight.Model.beans.Event;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class EventsDao  {
    //private Exception exception;


    public EventsDao(){
    }

    // CRUD Methods
    public void addEvent(@NonNull Event event) {
        String URL_API = "http://minecraftcoloc.ddns.net:1337/api/events/";
    }

    public void getAllEvents() {

        try {
            //private ProgressDialog pDialog;
            URL url = new URL("http://minecraftcoloc.ddns.net:1337/api/events/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            Log.e("INFO", String.valueOf(conn));

        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
    }
}
