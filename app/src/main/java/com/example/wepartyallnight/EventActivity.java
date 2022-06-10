package com.example.wepartyallnight;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EventActivity extends AppCompatActivity {

    static public Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        EventFeeder eventFeeder = new EventFeeder();
        eventFeeder.execute("1");
    }

    class EventFeeder extends AsyncTask<String, Void, Event> {
        private ProgressDialog pDialog;
        private String url_path="http://minecraftcoloc.ddns.net:1337/api/events/";
        private Exception exception;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(EventActivity.this);
            pDialog.setMessage("Please Wait...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected Event doInBackground(String... params) {
            try {
                String urlStr = this.url_path+params[0];
                String method = "GET";
                URL url = new URL(urlStr);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod(method);
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP Error code : "
                            + conn.getResponseCode());
                }
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                conn.disconnect();
                String eventStr = br.readLine();
                return new Event(new JSONObject(eventStr).getJSONObject("data").getJSONObject("attributes"));
            } catch (Exception e) {
                System.out.println("Exception in Event 'getById' : " + e);
                return null;
            }
        }

        protected void onPostExecute(Event event) {
            pDialog.dismiss();
            super.onPostExecute(event);
            EventActivity.event = event;
        }
    }
}