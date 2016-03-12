package com.example.hudaiftekhar.represent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;

import com.squareup.picasso.Picasso;

public class DetailedView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        Bundle bundle = getIntent().getExtras();

        if (bundle.getString("LOC_NAME6") != null) {
            String val = bundle.getString("LOC_NAME6");
            System.out.println("OLIVIAAAAAA" + val);
            String[] gps = val.split("\t");

            TextView textView = (TextView) findViewById(R.id.repName1);
            TextView textView2 = (TextView) findViewById(R.id.partyName1);
            TextView textView3 = (TextView) findViewById(R.id.endOfTerm);
            TextView textView4 = (TextView) findViewById(R.id.committeeName);
            TextView textView5 = (TextView) findViewById(R.id.nameRecentBills);

            textView.setText(gps[0]);
            textView2.setText(gps[1]);
            textView3.setText(gps[2]);
            textView4.setText(gps[3]);
            textView5.setText(gps[4]);


         //   (1st is names, 2nd is party names, 3rd is end date, 4th is committes, 5th is bills)



        }

        else {
            String actualName = bundle.getString("LOC_NAME3");


            String positionOne = bundle.getString("position");
            int pos = Integer.parseInt(positionOne);

            String[] val = bundle.getStringArray("name2");
            String nameOne = val[pos];

            String[] name1 = bundle.getStringArray("party2");
            String partyOne = name1[pos];

            String[] endDate1 = bundle.getStringArray("enddate2");
            String endDateOne = endDate1[pos];

            String[] commOne = bundle.getStringArray("comm");
            String commOnee = commOne[pos];

            String[] billName = bundle.getStringArray("bill");
            String bills = billName[pos];

            String[] bioguideID = bundle.getStringArray("picture");
            String bioGuide = bioguideID[pos];

            String url3 = "https://theunitedstates.io/images/congress/225x275/" + bioGuide + ".jpg";
            System.out.println("This is the URL " + url3);

            TextView textView = (TextView) findViewById(R.id.repName1);
            TextView textView2 = (TextView) findViewById(R.id.partyName1);
            TextView textView3 = (TextView) findViewById(R.id.endOfTerm);
            TextView textView4 = (TextView) findViewById(R.id.committeeName);
            TextView textView5 = (TextView) findViewById(R.id.nameRecentBills);

            ImageView imageView = (ImageView) findViewById(R.id.photo4);

            Picasso.with(DetailedView.this).load(bioGuide).into(imageView);


            textView.setText(nameOne); ////
            textView2.setText(partyOne);
            textView3.setText(endDateOne);
            textView4.setText("Committee Name: " + commOnee);
            textView5.setText(bills);
            // imageView.setImageResource(R.drawable.boxer);


        }
    }

}
