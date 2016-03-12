package com.example.hudaiftekhar.represent;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.os.Bundle;
import android.app.Activity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.crashlytics.android.Crashlytics;
import com.example.hudaiftekhar.represent.MobileArrayAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.AppSession;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

import android.util.Log;
import java.io.*;
import java.util.*;
import java.net.*;


import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import io.fabric.sdk.android.Fabric;

import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;
import com.twitter.sdk.android.tweetui.CompactTweetView;
import com.twitter.sdk.android.tweetui.TweetUi;
import com.twitter.sdk.android.tweetui.TweetViewAdapter;
import com.twitter.sdk.android.tweetui.TweetViewFetchAdapter;


public class CongressionalView extends ListActivity {


    String[] MOBILE_OS;
    String[] MOBILE_OS2;
    String[] MOBILE_OS3;
    String[] MOBILE_0S4;
    String[] MOBILE_OS5;
    String[] MOBILE_OS6;
    String[] MOBILE_OS7;
    String[] MOBILE_OS8;
    String[] MOBILE_OS9;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle bundle = getIntent().getExtras();
            String val = bundle.getString("LENGTH"); // obtain number of calories

            int i = Integer.parseInt(val);
            MOBILE_OS = new String[i];
            MOBILE_OS2 = new String[i];
            MOBILE_OS3 = new String[i];
            MOBILE_0S4 = new String[i];
            MOBILE_OS5 = new String[i];
            MOBILE_OS6 = new String[i];
            MOBILE_OS7 = new String[i];
            MOBILE_OS8 = new String[i];
            MOBILE_OS9 = new String[i];


            for (int m = 0; m < i; m++) {
                String val2 = bundle.getString("LOC_NAME" + m);
                MOBILE_OS[m] = val2;
                String val3 = bundle.getString("PARTY" + m);
                MOBILE_OS2[m] = val3;
                System.out.println("Annie" + MOBILE_OS[m]);
                String val4 = bundle.getString("EMAIL" + m);
                MOBILE_OS3[m] = val4;
                String val5 = bundle.getString("WEBSITE" + m);
                MOBILE_0S4[m] = val5;
                String val6 = bundle.getString("TWEETNAME" + m);
                MOBILE_OS5[m] = val6;
                String val7 = bundle.getString("ENDTERM" + m);
                MOBILE_OS6[m] = val7;
                System.out.println("WHat are you doing" + val7);
                String val8 = bundle.getString("BIOGUIDEID" + m);
                MOBILE_OS7[m] = val8;
                System.out.println("What are you doinnnggg " + val8);
                String val9 = bundle.getString("COMM" + m);
                MOBILE_OS8[m] = val9;
                String val10 = bundle.getString("BILL" + m);
                MOBILE_OS9[m] = val10;
            }

            setListAdapter(new MobileArrayAdapter(this, MOBILE_OS, MOBILE_OS2, MOBILE_OS3, MOBILE_0S4, MOBILE_OS5, MOBILE_OS6, MOBILE_OS7));


        }



        @Override
        protected void onListItemClick(ListView l, View v, int position, long id) {

            //get selected items
            String selectedValue = (String) getListAdapter().getItem(position);
            Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();

            System.out.println("This is working");

            Intent sendIntent4 = new Intent(CongressionalView.this, DetailedView.class);
            System.out.println("This is the end date " + MOBILE_OS6[position]);

            sendIntent4.putExtra("position", Integer.toString(position));
            sendIntent4.putExtra("name2", MOBILE_OS);
            sendIntent4.putExtra("party2", MOBILE_OS2);
            sendIntent4.putExtra("enddate2", MOBILE_OS6);
            sendIntent4.putExtra("comm", MOBILE_OS8);
            sendIntent4.putExtra("bill", MOBILE_OS9);
            sendIntent4.putExtra("picture", MOBILE_OS7);
           // sendIntent4.putExtra("name2", selectedValue);
            startActivity(sendIntent4);

        }



    }


