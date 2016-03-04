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
        String val = bundle.getString("name2");

        String val2 = bundle.getString("LOC_NAME3");

        TextView textView = (TextView) findViewById(R.id.repName1);
        TextView textView2 = (TextView) findViewById(R.id.partyName1);
        TextView textView3 = (TextView) findViewById(R.id.endOfTerm);
        TextView textView4 = (TextView) findViewById(R.id.committeeName);
        TextView textView5 = (TextView) findViewById(R.id.nameRecentBills);
        ImageView imageView = (ImageView) findViewById(R.id.photo4);

        if (val2 != null) {
            val = val2;
        }

        if (val.equals("Barbara Boxer")) {
            textView.setText("Barbara Boxer");
            textView2.setText("Democrat");
            textView3.setText("End of the Term: 2016");
            textView4.setText("Committee Name: Senate - Veterans' Affairs");
            textView5.setText("Name of Recent Bills: S. 2487: Female Veteran Suicide Prevention Act\n" +
                    "S. 2412: Tule Lake National Historic Site Establishment Act of 2015\n" +
                    "S. 2204: End of Suffering Act of 2015\n" +
                    "S. 2157: SAFE DRONE Act of 2015\n" +
                    "S. 2155: West Coast Ocean Protection Act of 2015\n" +
                    "S. 2037: Pell Grant Restoration Act of 2015\n" +
                    "S. 1983: Pechanga Band of Luiseno Mission Indians Water Rights Settlement Act");
            imageView.setImageResource(R.drawable.boxer);

        }
        else if (val.equals("Mike Honda")) {
            textView.setText("Mike Honda");
            textView2.setText("Democrat");
            textView3.setText("End of the Term: 2016");
            textView4.setText("Committee: United States House Committee on Appropriation");
            textView5.setText("Name of Recent Bills: H.R. 4471: Educator Preparation Reform Act\n" +
                    "H.Res. 561: Expressing support for support of transgender acceptance.\n" +
                    "H.R. 4013: Equity and Excellence in American Education Act of 2015\n" +
                    "H.Res. 519: Supporting the ideals and goals of the “International Day for the Elimination of ...\n" +
                    "H.R. 3926: Gun Violence Research Act\n" +
                    "H.R. 3807: Pay Our Bills Act\n" +
                    "H.Res. 471: Recognizing Filipino American History Month and celebrating the history and culture of Filipino ...");
            imageView.setImageResource(R.drawable.mikehonda);

        }
        else if (val.equals("Diane Feinstein")) {
            textView.setText("Diane Feinstein");
            textView2.setText("Democrat");
            textView3.setText("End of the Term: 2019");
            textView4.setText("Committee: Chairman of the Senate Intelligence Committee");
            textView5.setText("Name of Recent Bills: S. 2568: California Desert Conservation, Off-Road Recreation, and Renewable Energy Act\n" +
                    "S. 2552: Interstate Threats Clarification Act of 2016\n" +
                    "S. 2533: California Long-Term Provisions for Water Supply and Short-Term Provisions for Emergency Drought Relief ...");
            imageView.setImageResource(R.drawable.californiasenator);

        }
        else if (val.equals("Anna Eshoo")) {
            textView.setText("Anna Eshoo");
            textView2.setText("Democrat");
            textView3.setText("End of the Term: 2019");
            textView4.setText("Committee: Energy and Commerce Committee");
            textView5.setText("Name of Recent Bills: H.R. 3805: Broadband Conduit Deployment Act of 2015\n" +
                    "H.R. 3664: Promoting Good Cyber Hygiene Act of 2015\n" +
                    "H.R. 3341: To designate the portion of Moffett Federal Airfield, California, containing the 129th Rescue ...\n" +
                    "H.R. 2104: American Cures Act");
            imageView.setImageResource(R.drawable.annaeshoo);

        }
        else if (val.equals("Barbara Lee")) {
            textView.setText("Barbara Lee");
            textView2.setText("Democrat");
            textView3.setText("End of the Term: 2019");
            textView4.setText("Committee: House Energy and Commerce Committee");
            textView5.setText("H.R. 3712: Improving Access to Mental Health Act\n" +
                    "H.Con.Res. 77: Recognizing the 70th anniversary of the establishment of the United Nations.\n" +
                    "H.R. 2972: Equal Access to Abortion Coverage in Health Insurance (EACH Woman) Act of 2015");
            imageView.setImageResource(R.drawable.barbaralee);

        }
    }

}
