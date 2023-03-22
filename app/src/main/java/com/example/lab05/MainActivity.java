package com.example.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String TAG = "com.example.lab05.sharedpreferences";
    LifecycleData currentRun, lifeTime;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView currentRunTV, lifeTimeTV;
    Button clearCurrent, clearLifetime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //load SharedPreferences
        sharedPreferences = getSharedPreferences(TAG, MODE_PRIVATE);
        //instantiate editor
        editor = sharedPreferences.edit();
        currentRun = new LifecycleData();
        currentRun.duration = "Current Run";
        //get lifecycledata from SharedPreferences as String
        String lifecycleDataAsString = sharedPreferences.getString("lifetime", "");
        //instantiate a new LifecycleData if empty string
            //else convert the JSON to LifecycleData object
        if(lifecycleDataAsString.equals("")) {
            lifeTime = new LifecycleData();
            lifeTime.duration = "Lifetime";
        } else {
            lifeTime = LifecycleData.parseJson(lifecycleDataAsString);
        }
        //instantiate TextViews
        lifeTimeTV = findViewById(R.id.lifetime);
        currentRunTV = findViewById(R.id.current);
        //instantiate Buttons
        clearCurrent = findViewById(R.id.clearCurrent);
        clearLifetime = findViewById(R.id.clearLifetime);
        //get current enclosing method name
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);

        clearCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRun.clearEvent();
                displayData();
                storeData();
            }
        });

        clearLifetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lifeTime.clearEvent();
                displayData();
                storeData();
            }
        });
    }

    //display data on Textviews
    private void displayData() {
        lifeTimeTV.setText(lifeTime.toString());
        currentRunTV.setText(currentRun.toString());
    }
    //convert lifetime to String and store in SharedPreferences
    public void storeData() {
        editor.putString("lifetime", lifeTime.toJSON()).apply();
    }
    public void updateCount(String currentEnclosingMethod) {
        //pass name to LifecycleData to update count
        currentRun.updateEvent(currentEnclosingMethod);
        lifeTime.updateEvent(currentEnclosingMethod);
        displayData();
        storeData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onResume() {
        super.onResume();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onPause() {
        super.onPause();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onStop() {
        super.onStop();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        String currentEnclosingMethod = new Throwable()
                .getStackTrace()[0]
                .getMethodName();
        updateCount(currentEnclosingMethod);
    }
}