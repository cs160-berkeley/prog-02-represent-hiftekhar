package com.example.hudaiftekhar.represent;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.TextView;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;
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

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "wU7kWsisrQse3DEj09nz8NSgG";
    private static final String TWITTER_SECRET = "15NBFU1f5HRjVOxIpY5GUcfGpiRqxitjOSgJ9CegfiIpp2fCJS";


    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        setContentView(R.layout.activity_main2);

        if (extras != null) {
            String catName = extras.getString("LOC_NAME");
           /* String catName2 = extras.getString("LOC_NAME2");
            String catName3 = extras.getString("LOC_NAME3");*/

            String[] val = new String[10];
            System.out.println("Am I reaching here " + catName);

            if (catName != null ) {
                val = catName.split("\t");

                for (int i = 0; i < 10; i++ ) {
                    System.out.println("Val " + val[i]);
                }
            }

            /*System.out.println("catName2 " + catName2);
            System.out.println("catName3 " + catName3);*/

            // getting the LOC_NAME
            if (catName != null) {
                Intent sendIntent7 = new Intent(MainActivity2.this, CongressionalWear.class);
                sendIntent7.putExtra("LOC_NAME", val[0]); //length 3
                String[] name = val[1].split(","); // representative names.
                String[] party = val[2].split(","); // party names
                String[] endDate = val[7].split(",");



                String[] commOne = val[8].split(";");

                String[] billsOne = val[9].split(";");


               /* System.out.println("This is the size of the name array ");
                for (int i = 0; i < Integer.parseInt(val[0]); i++) {
                    System.out.println("Name " + name[i]);
                    System.out.println("Party " + party[i]);
                    System.out.println("State " + val[3]);
                    System.out.println("County " + val[4]);
                    System.out.println("End Date " + endDate[i]);
                    System.out.println("Committe " + commOne[i]);
                    System.out.println("Bills " + billsOne[i]);
                }*/
                sendIntent7.putExtra("REP_NAME", name);
                sendIntent7.putExtra("PARTY_NAME", party);
                sendIntent7.putExtra("STATE", val[3]);
                sendIntent7.putExtra("COUNTY", val[4]);
                sendIntent7.putExtra("%O", val[5]);
                sendIntent7.putExtra("%R", val[6]);
                sendIntent7.putExtra("END_DATE", endDate);
                sendIntent7.putExtra("COMM", commOne);
                sendIntent7.putExtra("BILLS", billsOne);
                startActivity(sendIntent7);
            }

        }


        /*Intent sendIntent11 = new Intent(this, SensorActivity.class);
        System.out.println("Huda Going to sensor activity");
        startActivity(sendIntent11);*/

    }


}
