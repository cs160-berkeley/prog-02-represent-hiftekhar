package com.example.hudaiftekhar.represent;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {
            String catName = extras.getString("LOC_NAME");
           // mFeedBtn.setText("Feed " + catName);

            // getting the LOC_NAME
            Intent sendIntent7 = new Intent(MainActivity2.this, CongressionalWear.class);
            sendIntent7.putExtra("LOC_NAME", catName); //passing LOC_NAME to CongressionalWear
            startActivity(sendIntent7);
        }

        /*
        Intent sendIntent11 = new Intent(this, SensorActivity.class);
        System.out.println("Huda Going to sensor activity");
        startActivity(sendIntent11);*/

    }


}
