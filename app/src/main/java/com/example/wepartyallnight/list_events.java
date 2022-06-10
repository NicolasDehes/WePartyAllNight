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
import java.util.ArrayList;
import java.util.List;

public class list_events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_events);
        EventAll eventAll = new EventAll();
        eventAll.execute();
    }

    class EventAll extends AsyncTask<String, Void, List<Event>> {
        private ProgressDialog pDialog;
        public String url_path="http://minecraftcoloc.ddns.net:1337/api/events";
        private Exception exception;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pDialog = new ProgressDialog(list_events.this);
            pDialog.setMessage("Récupération des événements...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected List<Event> doInBackground(String... params) {
            try {
                URL url = new URL(url_path);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
                }
                InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                conn.disconnect();
                String eventStr = "";
                List<Event> listEvents = new ArrayList<Event>();
                while ((eventStr = br.readLine()) != null) {
                    listEvents.add(new Event(new JSONObject(eventStr).getJSONObject("data").getJSONObject("attributes")));
                }
                return listEvents;
            } catch (Exception e) {
                System.out.println("Exception in Event 'getById' : " + e);
                return null;
            }
        }

        protected void onPostExecute(List<Event> listEvents) {
            pDialog.dismiss();
            super.onPostExecute(listEvents);
            /*
                TO DO : METTRE LA LIST EVENT DANS UNE RECYCLER VIEW
             */
        }
    }
}