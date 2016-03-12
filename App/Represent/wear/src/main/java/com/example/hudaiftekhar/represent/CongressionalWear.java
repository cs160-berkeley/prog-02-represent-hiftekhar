package com.example.hudaiftekhar.represent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import android.support.wearable.view.GridViewPager;
import android.view.View;


public class CongressionalWear extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congressional_wear);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();


        System.out.println("LULULULULULULUUUUU");
        String catName = extras.getString("LOC_NAME"); // length of num reps and senators
        String[] repNames = extras.getStringArray("REP_NAME"); // rep names
        String[] partyNames = extras.getStringArray("PARTY_NAME"); // party names
        String state = extras.getString("STATE");
        String obama = extras.getString("%O");
        String county = extras.getString("COUNTY");
        String romney = extras.getString("%R");

        String[] endDate = extras.getStringArray("END_DATE");
        String[] comm = extras.getStringArray("COMM");
        String[] bills = extras.getStringArray("BILLS");

        final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
        pager.setAdapter(new CongressionalAdapter(this, getFragmentManager(), catName, repNames, partyNames, state, county, obama, romney, endDate, comm, bills));

    }



}
