package com.example.ravichandra.serviceusinghandler;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

/**
 * Created by Ravichandra on 1/8/2018.
 */

public class ServiceExample extends Service{


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        latlongs();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    private void latlongs()
    {

        String url1 = "https://api.androidhive.info/volley/person_array.json";

        JsonArrayRequest req = new JsonArrayRequest(url1,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("response", response.toString());
                    //    pDialog.hide();
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                latlongs();
                            }
                        }, 5000);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("response", "Error: " + error.getMessage());

                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        latlongs();
                    }
                }, 5000);

            }
        });
        NetworkSingleton.getInstance(getApplicationContext()).addtoRequestQue(req);
    }
}
