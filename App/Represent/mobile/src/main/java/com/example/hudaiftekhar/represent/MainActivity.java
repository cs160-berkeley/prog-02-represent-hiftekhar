package com.example.hudaiftekhar.represent;

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

// when buttons are pressed, they start the PhoneToWatchService
// with zip code/location passed in

public class MainActivity extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {


    private GoogleApiClient mGoogleApiClient;
    private String mLatitudeText;
    private String mLongitudeText;
    protected Location mLastLocation;
    private String TAG;

    static InputStream is = null;
    static String json = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //  TAG = "Hey guys";

        // mLatitudeText = (TextView) findViewById((R.id.mLatitudeText));


        buildGoogleApiClient();
    }

    /**
     * Builds a GoogleApiClient. Uses the addApi() method to request the LocationServices API.
     */
    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        if (mLastLocation != null) {
            mLatitudeText= String.valueOf(mLastLocation.getLatitude());
            mLongitudeText = String.valueOf(mLastLocation.getLongitude());
            //    mLongitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
        }
        else {
            System.out.print("Hey it's Lulu");
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // Refer to the javadoc for ConnectionResult to see what error codes might be returned in
        // onConnectionFailed.
        Log.i(TAG, "Connection failed: ConnectionResult.getErrorCode() = " + result.getErrorCode());
    }


    @Override
    public void onConnectionSuspended(int cause) {
        // The connection to Google Play services was lost for some reason. We call connect() to
        // attempt to re-establish the connection.
        Log.i(TAG, "Connection suspended");
        mGoogleApiClient.connect();
    }


    // Current Screen CHECK //

    public void sendNextScreen2(View v) {

        String url = "http://congress.api.sunlightfoundation.com/legislators/locate?latitude=" + mLatitudeText + "&longitude=" + mLongitudeText + "&apikey=66b10d2ec6df4b2cb03b12a347171314";

        //  https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&
        System.out.println(url);

        // send to Congressional View
        Intent sendIntent4 = new Intent(MainActivity.this, Preview.class);
        sendIntent4.putExtra("LOC_NAME", url);
        startActivity(sendIntent4);

        /*Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
        sendIntent.putExtra("LOC_NAME", url);
        startService(sendIntent);*/

    }

    public void sendNextScreen(View v) {


        EditText textOne = (EditText) findViewById(R.id.editText);
        final String zipCode = textOne.getText().toString();

        String url = "http://congress.api.sunlightfoundation.com/legislators/locate?zip=" + zipCode + "&apikey=66b10d2ec6df4b2cb03b12a347171314";


        Intent sendIntent2 = new Intent(MainActivity.this, Preview.class);
        sendIntent2.putExtra("LOC_NAME", url);
        startActivity(sendIntent2);

        //making a  call to phone to watch
       /* Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
        sendIntent.putExtra("LOC_NAME", zipCode);
        startService(sendIntent);*/

    }
}
