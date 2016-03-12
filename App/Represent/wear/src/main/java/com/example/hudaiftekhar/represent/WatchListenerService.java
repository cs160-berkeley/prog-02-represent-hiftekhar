package com.example.hudaiftekhar.represent;

/**
 * Created by hudaiftekhar on 2/27/16.
 */
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;

import java.nio.charset.StandardCharsets;

/**
 * Created by joleary and noon on 2/19/16 at very late in the night. (early in the morning?)
 */
public class WatchListenerService extends WearableListenerService {
    // In PhoneToWatchService, we passed in a path, either "/FRED" or "/LEXY"
    // These paths serve to differentiate different phone-to-watch messages
    private static final String zipCode = "/LENGTH";
    private static final String zipCode2 = "/NAME";
    private static final String zipCode3 = "/PARTY";
    private static int count = 0;


    @Override
    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("T", "in WatchListenerService, got: " + messageEvent.getPath());
        //use the 'path' field in sendmessage to differentiate use cases
        //(here, fred vs lexy)

        if( messageEvent.getPath().equalsIgnoreCase( zipCode ) ) {

            count = count + 1;
            System.out.print("SOS SOMEONE HELP ME");
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
            Intent intent = new Intent(this, MainActivity2.class );
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("LOC_NAME", value);
            Log.d("T", "about to start watch MainActivity with CAT_NAME: Fred");
            startActivity(intent);
        } else if (messageEvent.getPath().equalsIgnoreCase(zipCode2)) {
            count = count+ 1;
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);
          /*  Intent intent = new Intent(this, MainActivity2.class );
            intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
            //you need to add this flag since you're starting a new activity from a service
            intent.putExtra("LOC_NAME2", value);
            Log.d("T", "about to start watch MainActivity with CAT_NAME: Lexy");
            startActivity(intent);*/
        }
        else {
            super.onMessageReceived( messageEvent );
        }
    }
}