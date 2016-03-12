package com.example.hudaiftekhar.represent;

/**
 * Created by hudaiftekhar on 2/28/16.
 */

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.*;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.*;
import io.fabric.sdk.android.Fabric;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;


public class MobileArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private final String[] values2;
    private final String[] values3;
    private final String[] values4;
    private final String[] values5;
    private final String[] values6;
    private final String[] values7;


    private final String key = "GIrn4To49wc8FpKD2vMCDEPwl";
    private final String secret = "2Vhrfwd5NTQe12yx4T4Odo3lQhh8xrW5e0Qv9OKsNB2ZPdjlWW";


//    private TwitterLoginButton loginButton;

    public MobileArrayAdapter(Context context, String[] values, String[] values2, String[] values3, String[] values4, String[] values5, String[] values6, String[] values7) {
        super(context, R.layout.my_list, values);
        this.context = context;
        this.values = values;
        this.values2 = values2;
        this.values3 = values3;
        this.values4 = values4;
        this.values5 = values5;
        this.values6 = values6;
        this.values7 = values7;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView;
        rowView = inflater.inflate(R.layout.my_list, parent, false);




        TextView textView = (TextView) rowView.findViewById(R.id.name);
        TextView textView2 = (TextView) rowView.findViewById(R.id.party);
        TextView textView3 = (TextView) rowView.findViewById(R.id.email);
        TextView textView4 = (TextView) rowView.findViewById(R.id.website);
        TextView textView5 = (TextView) rowView.findViewById(R.id.latesttweet);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.photo);

        Button button11 = (Button) rowView.findViewById(R.id.buttonHere);
        button11.setFocusable(false);
        button11.setClickable(false);
        button11.setText("MORE INFO");

        textView.setText(values[position]);
        textView5.setText("tweet");

       // loginButton = (TwitterLoginButton) findViewById(R.id.twitter_login_button);


        textView.setText(values[position]);
        textView2.setText(values2[position]);
        textView3.setText(values3[position]);
        textView4.setText(values4[position]);


        System.out.println("This is the values " + values7[position]);
        String url3 = "https://theunitedstates.io/images/congress/225x275/" + values7[position] + ".jpg";
        System.out.println("THIS IS THE URL " + url3);
        Picasso.with(context).load(url3).into(imageView);


        // Change icon based on name
        String s = values[position];


        System.out.println(s);


        return rowView;
    }


}