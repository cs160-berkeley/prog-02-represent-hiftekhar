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

        String catName = extras.getString("LOC_NAME");

        final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
        pager.setAdapter(new CongressionalAdapter(this, getFragmentManager(), catName));

    }

    /* Hopefully send stuff to phone */


}
