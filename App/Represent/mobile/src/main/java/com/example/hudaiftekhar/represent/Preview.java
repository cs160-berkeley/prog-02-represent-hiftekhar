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

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.core.services.StatusesService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import io.fabric.sdk.android.Fabric;

public class Preview extends AppCompatActivity {

    String[] MOBILE_OS; // name
    String[] MOBILE_OS2; //party
    String[] MOBILE_OS3; //oc_email
    String[] MOBILE_OS4; //website
    String[] MOBILE_OS5; //twitter_id
    String[] MOBILE_OS6; //end date
    String[] MOBILE_OS7; //bioguide_id
    String[] MOBILE_OS8; //committee names
    String[] MOBILE_OS9; //bill
    String[] MOBILE_OS10; //city
    String whichState;


    private final String key = "GIrn4To49wc8FpKD2vMCDEPwl";
    private final String secret = "2Vhrfwd5NTQe12yx4T4Odo3lQhh8xrW5e0Qv9OKsNB2ZPdjlWW";

    String url2;
    String url3;
    String result;
    int length1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        url2 = bundle.getString("LOC_NAME"); // obtain number of calories
        //  setContentView(R.layout.activity_congressional_view);
        url3 = bundle.getString("LOC_NAME2");

        System.out.println("Reaches heres");
        String stringUrl = url2;
        System.out.println("This is the url" + url2);
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            System.out.println("So far working");
            new DownloadWebpageTask().execute(stringUrl);
            System.out.println("hiii guiseee");

        } else {
            System.out.println("No network connection available.");
        }



    }


    // Uses AsyncTask to create a task away from the main UI thread. This task takes a
    // URL string and uses it to create an HttpUrlConnection. Once the connection
    // has been established, the AsyncTask downloads the contents of the webpage as
    // an InputStream. Finally, the InputStream is converted into a string, which is
    // displayed in the UI by the AsyncTask's onPostExecute method.
    private class DownloadWebpageTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {


            Intent sendIntent2 = new Intent(Preview.this, CongressionalView.class);
            //length

            //URL3 (reverse geocoding)--> look at 2012 JSON
            HttpURLConnection urlConnection;
            // params comes from the execute() call: params[0] is the url.
            try {
                String thisUrl = urls[0];
                System.out.println("This is working fine");
                URL url = new URL(thisUrl);
                urlConnection = (HttpURLConnection) url.openConnection();
                //////////////////////////

                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;

                    while ((line = bufferedReader.readLine()) != null) {
                        System.out.println("EMILY");
                        stringBuilder.append(line).append("\n");
                    }

                    bufferedReader.close();
                    result = stringBuilder.toString();
                    System.out.println("How does this werk tho?");
                    ///////////////// /////////////////////

                    try {
                        System.out.println("Does it go this far");
                        JSONObject jObject = new JSONObject(result);
                        String aJsonString = jObject.getString("count");
                        System.out.println("This is the number of items " + aJsonString);

                        int i = Integer.parseInt(aJsonString);
                        length1 = i;
                        //    return i;
                        MOBILE_OS = new String[i];
                        MOBILE_OS2 = new String[i];
                        MOBILE_OS3 = new String[i];
                        MOBILE_OS4 = new String[i];
                        MOBILE_OS5 = new String[i];
                        MOBILE_OS6 = new String[i];
                        MOBILE_OS7 = new String[i];

                        MOBILE_OS8 = new String[i];
                        MOBILE_OS9 = new String[i];
                        MOBILE_OS10 = new String[i];

                        JSONArray arrayone = jObject.getJSONArray("results");
                        System.out.println("This is the length of jsonarray" + arrayone.length());

                        for (int j = 0; j < arrayone.length(); j++) {
                            try {
                                JSONObject oneObject = arrayone.getJSONObject(j);

                                whichState = oneObject.getString("state");

                                String mobile = oneObject.getString("first_name");
                                String mobile2 = oneObject.getString("last_name");
                                String party = oneObject.getString("party");
                                String email = oneObject.getString("oc_email");
                                String website = oneObject.getString("website");
                                String tweetName = oneObject.getString("twitter_id");
                                String endDate = oneObject.getString("term_end");
                                System.out.println("This is the end date" + endDate);
                                String bioguideId = oneObject.getString("bioguide_id");

                                MOBILE_OS10[j] = oneObject.getString("title");
                                //MOBILE_OS[length] = mobile + " " + mobile2;
                                MOBILE_OS[j] = mobile + " " + mobile2;
                                MOBILE_OS2[j] = party;
                                MOBILE_OS3[j] = email;
                                MOBILE_OS4[j] = website;
                                MOBILE_OS5[j] = tweetName;
                                MOBILE_OS6[j] = endDate;
                                MOBILE_OS7[j] = bioguideId;

                                System.out.println("This is the bioguide id" + bioguideId);
                                System.out.println("This is value of MOBILE_OS at index 0 " + MOBILE_OS[j]);

                                System.out.println("THIS IS YO nAME JO");

                                // System.out.println("This werks" + mobile);

                                //MOBILE_OS[i] = fullName;
                            }

                            catch (JSONException e) {
                                System.out.println("This be a prob 1");
                            }
                        }





                        sendIntent2.putExtra("LENGTH", Integer.toString(length1));

                        String val = "";
                        for (int j = 0; j < length1; j++) {
                            String LOC_VAL = Integer.toString(j);
                            sendIntent2.putExtra("LOC_NAME" + LOC_VAL, MOBILE_OS[j]);
                            sendIntent2.putExtra("PARTY" + LOC_VAL, MOBILE_OS2[j]);
                            sendIntent2.putExtra("EMAIL" + LOC_VAL, MOBILE_OS3[j]);
                            sendIntent2.putExtra("WEBSITE" + LOC_VAL, MOBILE_OS4[j]);
                            sendIntent2.putExtra("TWEETNAME" + LOC_VAL, MOBILE_OS5[j]);
                            sendIntent2.putExtra("ENDTERM" + LOC_VAL, MOBILE_OS6[j]);
                            sendIntent2.putExtra("BIOGUIDEID" + LOC_VAL, MOBILE_OS7[j]);
                            System.out.println("Where is it? " + LOC_VAL + " " +  MOBILE_OS7[j]);
                        }
                      //  startActivity(sendIntent2);





                    }
                    catch (JSONException e) {
                        System.out.println("this is a prob");
                    }

                    //////////////// /////////////////////
                }
                finally {
                    urlConnection.disconnect();
                }
            } catch (Exception e) {
                System.out.println("Unable to retrieve web page. URL may be invalid.");
            }

            System.out.println("This is the length " + length1);



            for (int i = 0; i < length1; i++) {
                // params comes from the execute() call: params[0] is the url.
                try {
                    String thisUrl = "http://congress.api.sunlightfoundation.com/committees?member_ids=" + MOBILE_OS7[i] + "&apikey=66b10d2ec6df4b2cb03b12a347171314";


                    URL url = new URL(thisUrl);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    //////////////////////////

                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;

                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println("EMILY");
                            stringBuilder.append(line).append("\n");
                        }

                        bufferedReader.close();
                        result = stringBuilder.toString();
                        System.out.println("How does this werk tho?");
                        System.out.println(result);
                        ///////////////// /////////////////////

                        try {
                            System.out.println("Does it go this far");
                            JSONObject jObject = new JSONObject(result);
                            String aJsonString = jObject.getString("count");
                            System.out.println("This is the number of items " + aJsonString);

                            int m = Integer.parseInt(aJsonString);


                            String val = "";
                           /* length1 = i;
                            //    return i;
                            MOBILE_OS = new String[i];
                            MOBILE_OS2 = new String[i];
                            MOBILE_OS3 = new String[i];
                            MOBILE_OS4 = new String[i];
                            MOBILE_OS5 = new String[i];
                            MOBILE_OS6 = new String[i];
                            MOBILE_OS7 = new String[i];*/

                            JSONArray arrayone = jObject.getJSONArray("results");
                            System.out.println("This is the length of jsonarray" + arrayone.length());

                            for (int j = 0; j < arrayone.length(); j++) {
                                try {
                                    JSONObject oneObject = arrayone.getJSONObject(j);
                                    String mobile = oneObject.getString("name");
                                    //    System.out.println(mobile + " " + j);
                                    val = val + mobile + "\n";

                                    //MOBILE_OS[i] = fullName;
                                } catch (JSONException e) {
                                    System.out.println("This be a prob 1");
                                }
                            }

                            MOBILE_OS8[i] = val;
                            sendIntent2.putExtra("COMM" + i, MOBILE_OS8[i]);

                            //       System.out.println("Val "+ MOBILE_OS8[i]);


                        } catch (JSONException e) {
                            System.out.println("this is a prob");
                        }

                        //////////////// /////////////////////
                    } finally {
                        urlConnection.disconnect();
                    }
                } catch (Exception e) {
                    System.out.println("Unable to retrieve web page. URL may be invalid.");
                }


            }
////////////////////////////////////////////////////////////////

//////////////////*************************************////////////////

            for (int i = 0; i < length1; i++) {
                try {
                    String thisUrl = "http://congress.api.sunlightfoundation.com/bills?sponsor_id=" + MOBILE_OS7[i] + "&apikey=66b10d2ec6df4b2cb03b12a347171314";


                    URL url = new URL(thisUrl);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    //////////////////////////

                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;

                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println("EMILY");
                            stringBuilder.append(line).append("\n");
                        }

                        bufferedReader.close();
                        result = stringBuilder.toString();
                        System.out.println("How does this werk tho?");
                        System.out.println("Bill");
                        //  System.out.println(result);
                        ///////////////// /////////////////////

                        try {
                            System.out.println("Does it go this far");
                            String val = "";
                            JSONObject jObject = new JSONObject(result);

                            JSONArray arrayone = jObject.getJSONArray("results");
                            System.out.println("This is the length of jsonarray" + arrayone.length());

                            for (int j = 0; j < arrayone.length(); j++) {
                                try {
                                    JSONObject oneObject = arrayone.getJSONObject(j);
                                    String mobile = oneObject.getString("official_title");
                                    String dateInt = oneObject.getString("introduced_on");
                                    System.out.println(mobile + " " + "SHORT TITLE");
                                    System.out.println(dateInt + " " + "INTRODUCED");
                                    val = val + dateInt + ": " + mobile + "\n";

                                    //MOBILE_OS[i] = fullName;
                                } catch (JSONException e) {
                                    System.out.println("This be a prob 1");
                                }
                            }

                            MOBILE_OS9[i]= val;
                            sendIntent2.putExtra("BILL" + i, MOBILE_OS9[i]);


                        } catch (JSONException e) {
                            System.out.println("this is a prob");
                        }

                        //////////////// /////////////////////
                    } finally {
                        urlConnection.disconnect();
                    }
                } catch (Exception e) {
                    System.out.println("Unable to retrieve web page. URL may be invalid.");
                }
            }

//////////////////************************************/////////////////
// congress.api.sunlightfoundation.com/bills?sponsor_id=1234 //


            //Intent sendIntent2 = new Intent(Preview.this, CongressionalView.class);
            //length
            /*sendIntent2.putExtra("LENGTH", Integer.toString(length1));

            for (int j = 0; j < length1; j++) {
                String LOC_VAL = Integer.toString(j);
                sendIntent2.putExtra("LOC_NAME" + LOC_VAL, MOBILE_OS[j]);
                sendIntent2.putExtra("PARTY" + LOC_VAL, MOBILE_OS2[j]);
                sendIntent2.putExtra("EMAIL" + LOC_VAL, MOBILE_OS3[j]);
                sendIntent2.putExtra("WEBSITE" + LOC_VAL, MOBILE_OS4[j]);
                sendIntent2.putExtra("TWEETNAME" + LOC_VAL, MOBILE_OS5[j]);
                sendIntent2.putExtra("ENDTERM" + LOC_VAL, MOBILE_OS6[j]);
                sendIntent2.putExtra("BIOGUIDEID" + LOC_VAL, MOBILE_OS7[j]);
                sendIntent2.putExtra("COMM" + LOC_VAL, MOBILE_OS8[j]);
                sendIntent2.putExtra("BILL" + LOC_VAL, MOBILE_OS9[j]);
            }*/
            startActivity(sendIntent2);


            //  System.out.println("This is the length " + length1);
            //  System.out.println("This is the name " + MOBILE_OS[0]);
            //  System.out.println("This is the party " + MOBILE_OS2[0]);
            String value4 = "";
            String value5 = "";
            String percentageO = "0";
            String percentageR = "0";
            String value6 = "";
            String value7 = "";
            String value8 = "";
            String value9 = "";

            String whichState4 = "";

            for (int j = 0; j <length1; j++) {
                if (j != 0) {
                    value4 = value4 + "," + MOBILE_OS[j];
                    value5 = value5 + "," + MOBILE_OS2[j];
                    value6 = value6 + "," + MOBILE_OS10[j];
                    value7 = value7 + "," + MOBILE_OS6[j];
                    value8 = value8 + ";" + MOBILE_OS8[j];
                    value9 = value9 + ";" + MOBILE_OS9[j];
                    whichState4 = whichState + "," + whichState;
                }
                else {
                    value4 = MOBILE_OS[j];
                    value5 = MOBILE_OS2[j];
                    value6 = MOBILE_OS10[j];
                    value7 = MOBILE_OS6[j];
                    value8 = MOBILE_OS8[j];
                    value9 = MOBILE_OS9[j];
                    whichState4 = whichState;
                }
            }




            String county = "";

            try {
                    String thisUrl = url3;

                System.out.println("This is the url " + thisUrl);

                    URL url = new URL(thisUrl);
                     urlConnection = (HttpURLConnection) url.openConnection();
                    //////////////////////////

                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        StringBuilder stringBuilder = new StringBuilder();
                        String line;

                        while ((line = bufferedReader.readLine()) != null) {
                            System.out.println("EMILY");
                            stringBuilder.append(line).append("\n");
                        }

                        bufferedReader.close();
                        result = stringBuilder.toString();

                        System.out.println("This is the result" + result);

                        System.out.println("How does this werk tho?");
                        System.out.println("Bill");
                      //  System.out.println(result);
                        ///////////////// /////////////////////

                       try {
                            System.out.println("Does it go this far");
                           String val = "";
                            JSONObject jObject = new JSONObject(result);

                            JSONArray arrayone = jObject.getJSONArray("results");
                        //    JSONObject obj3 = arrayone.getJSONObject(0);


                            System.out.println(arrayone);
                            JSONObject arrayTwo = arrayone.getJSONObject(0);
                           System.out.println("This is the array " + arrayTwo);
                           JSONArray arrayFour = arrayTwo.getJSONArray("address_components");
                           System.out.println("This is the array 2 " + arrayFour);
                           JSONObject struggleBus = arrayFour.getJSONObject(2);
                           System.out.println("This is the object " + struggleBus);
                           String val5 = struggleBus.getString("long_name");
                           System.out.println("This is the val5 " + val5);

                           String val6 = val5.replace(" County", "");
                           System.out.println("HICOUNTY" + val6 + "lalaa");

                           county = val6;
                        //   JSONObject jObject2 = arrayTwo.getJSONObject(2);

                                  /*  String val3 = jObject2.getString("long_name");
                                    System.out.println("This is the county " + val3);*/


                                    //MOBILE_OS[i] = fullName;


                           InputStream stream = getAssets().open("states.json");
                           int size = stream.available();
                           byte[] buffer = new byte[size];
                           stream.read(buffer);
                           stream.close();
                           String jsonString = new String(buffer, "UTF-8");


                           JSONArray jObject1 = new JSONArray(jsonString);
                           for (int i = 0; i < jObject1.length(); i++) {
                               JSONObject obj5 = jObject1.getJSONObject(i);
                               String val4 = obj5.getString("county-name");
                               if (val4.equals(county)) {
                                   percentageO = obj5.getString("obama-percentage");
                                   percentageR = obj5.getString("romney-percentage");
                                   System.out.println("This is the percentage " + percentageO);
                                   System.out.println("This is the percentage 2 " + percentageR);
                               }

                           }


                        } catch (JSONException e) {
                            System.out.println("this is a prob");
                        }

                        //////////////// /////////////////////
                    } finally {
                        urlConnection.disconnect();
                    }
                } catch (Exception e) {
                    System.out.println("Unable to retrieve web page. URL may be invalid.");
                }


            //URL3


            //Sen or Rep

           Intent sendIntent4 = new Intent(getBaseContext(), PhoneToWatchService.class);
            String val = length1 + "\t" + value4 + "\t" + value5 + "\t" + whichState + "\t" + county + "\t" + percentageO + "\t" + percentageR + "\t" + value7 + "\t" + value8 + "\t" + value9;

            sendIntent4.putExtra("LENGTH", val);
            startService(sendIntent4);



/////////////////////////////////////////////////////////////////////////////////////






            // System.out.println("This is the result" + result);
            return null;
        }
        // onPostExecute displays the results of the AsyncTask.


    }
}
