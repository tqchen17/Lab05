package com.example.lab05;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class LifecycleData {
    int onCreate = 0;
    int onStart = 0;
    int onResume = 0;
    int onPause = 0;
    int onStop = 0;
    int onRestart = 0;
    int onDestroy = 0;
    String duration;
    public String toString() {
        return duration + "\n" +
                "onCreate \t\t\t\t\t" + onCreate + "\n" +
                "onStart \t\t\t\t\t\t\t" + onStart + "\n" +
                "onResume \t\t\t\t" + onResume + "\n" +
                "onPause \t\t\t\t\t" + onPause + "\n" +
                "onStop \t\t\t\t\t\t\t" + onStop + "\n" +
                "onRestart \t\t\t\t" + onRestart + "\n" +
                "onDestroy \t\t\t\t" + onDestroy;
    }
    //convert this instance to a String
    String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this, LifecycleData.class);
    }
    //from JSON String to class using GSON
    static LifecycleData parseJson(String fromSharedPreferences) {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(fromSharedPreferences, LifecycleData.class);
    }
    public void updateEvent(String currentEnclosingMethod) {
        switch(currentEnclosingMethod) {
            case "onCreate":
                onCreate++;
                break;
            case "onStart":
                onStart++;
                break;
            case "onResume":
                onResume++;
                break;
            case "onPause":
                onPause++;
                break;
            case "onStop":
                onStop++;
                break;
            case "onRestart":
                onRestart++;
                break;
            case "onDestroy":
                onDestroy++;
                break;
            default:break;
        }
    }
    public void clearEvent() {
        onCreate = 0;
        onStart = 0;
        onResume = 0;
        onPause = 0;
        onStop = 0;
        onRestart = 0;
        onDestroy = 0;
    }
}

