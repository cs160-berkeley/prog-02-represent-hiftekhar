package com.example.hudaiftekhar.represent;


        import android.app.Service;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.IBinder;
        import android.util.Log;
        import android.widget.Toast;

        import com.google.android.gms.wearable.MessageEvent;
        import com.google.android.gms.wearable.WearableListenerService;

        import java.nio.charset.StandardCharsets;

/**
 * Created by joleary and noon on 2/19/16 at very late in the night. (early in the morning?)
 */
public class PhoneListenerService extends WearableListenerService {

    //   WearableListenerServices don't need an iBinder or an onStartCommand: they just need an onMessageReceieved.
    private static final String TOAST = "/Barbara Boxer";
    private static final String TOAST1 = "/Diane Feinstein";
    private static final String TOAST2 = "/Barbara Lee";
    private static final String TOAST3 = "/Mike Honda";
    private static final String TOAST4 = "/Anna Eshoo";
    private static final String TOAST5 = "/SHAKE";
    @Override

    public void onMessageReceived(MessageEvent messageEvent) {
        Log.d("T", "in PhoneListenerService, got: " + messageEvent.getPath());
        /*if( messageEvent.getPath().equalsIgnoreCase(TOAST5) ) {

            // Value contains the String we sent over in WatchToPhoneService, "good job"
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);

            // Make a toast with the String
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;

            System.out.println("hey it's me ");
            Intent newIntent = new Intent(this, Hey2.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            newIntent.putExtra("LOC_NAME4", value);
            startActivity(newIntent);


            //Toast toast = Toast.makeText(context, value, duration);
            //toast.show();

            // so you may notice this crashes the phone because it's
            //''sending message to a Handler on a dead thread''... that's okay. but don't do this.
            // replace sending a toast with, like, starting a new activity or something.
            // who said skeleton code is untouchable? #breakCSconceptions

        }*/
        if( messageEvent.getPath().equalsIgnoreCase(TOAST) ) {

            // Value contains the String we sent over in WatchToPhoneService, "good job"
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);

            // Make a toast with the String
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_SHORT;
            Intent newIntent = new Intent(this, DetailedView.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            newIntent.putExtra("LOC_NAME3", value);
            startActivity(newIntent);

            //Toast toast = Toast.makeText(context, value, duration);
            //toast.show();

            // so you may notice this crashes the phone because it's
            //''sending message to a Handler on a dead thread''... that's okay. but don't do this.
            // replace sending a toast with, like, starting a new activity or something.
            // who said skeleton code is untouchable? #breakCSconceptions

        }
        if( messageEvent.getPath().equalsIgnoreCase(TOAST1) ) {

            // Value contains the String we sent over in WatchToPhoneService, "good job"
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);

            // Make a toast with the String
            //  Context context = getApplicationContext();
            //  int duration = Toast.LENGTH_SHORT;

            Intent newIntent = new Intent(this, DetailedView.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // newIntent.putExtra("LOC_NAME3", value);
            startActivity(newIntent);

            //Toast toast = Toast.makeText(context, value, duration);
            //toast.show();

            // so you may notice this crashes the phone because it's
            //''sending message to a Handler on a dead thread''... that's okay. but don't do this.
            // replace sending a toast with, like, starting a new activity or something.
            // who said skeleton code is untouchable? #breakCSconceptions

        }
        if( messageEvent.getPath().equalsIgnoreCase(TOAST2) ) {

            // Value contains the String we sent over in WatchToPhoneService, "good job"
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);

            // Make a toast with the String
            //  Context context = getApplicationContext();
            //  int duration = Toast.LENGTH_SHORT;

            Intent newIntent = new Intent(this, DetailedView.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // newIntent.putExtra("LOC_NAME3", value);
            startActivity(newIntent);

            //Toast toast = Toast.makeText(context, value, duration);
            //toast.show();

            // so you may notice this crashes the phone because it's
            //''sending message to a Handler on a dead thread''... that's okay. but don't do this.
            // replace sending a toast with, like, starting a new activity or something.
            // who said skeleton code is untouchable? #breakCSconceptions

        }
        if( messageEvent.getPath().equalsIgnoreCase(TOAST3) ) {

            // Value contains the String we sent over in WatchToPhoneService, "good job"
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);

            // Make a toast with the String
            //  Context context = getApplicationContext();
            //  int duration = Toast.LENGTH_SHORT;

            Intent newIntent = new Intent(this, DetailedView.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // newIntent.putExtra("LOC_NAME3", value);
            startActivity(newIntent);

            //Toast toast = Toast.makeText(context, value, duration);
            //toast.show();

            // so you may notice this crashes the phone because it's
            //''sending message to a Handler on a dead thread''... that's okay. but don't do this.
            // replace sending a toast with, like, starting a new activity or something.
            // who said skeleton code is untouchable? #breakCSconceptions

        }
        if( messageEvent.getPath().equalsIgnoreCase(TOAST4) ) {

            // Value contains the String we sent over in WatchToPhoneService, "good job"
            String value = new String(messageEvent.getData(), StandardCharsets.UTF_8);

            // Make a toast with the String
            //  Context context = getApplicationContext();
            //  int duration = Toast.LENGTH_SHORT;

            Intent newIntent = new Intent(this, DetailedView.class);
            newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // newIntent.putExtra("LOC_NAME3", value);
            startActivity(newIntent);

            //Toast toast = Toast.makeText(context, value, duration);
            //toast.show();

            // so you may notice this crashes the phone because it's
            //''sending message to a Handler on a dead thread''... that's okay. but don't do this.
            // replace sending a toast with, like, starting a new activity or something.
            // who said skeleton code is untouchable? #breakCSconceptions

        }
        else {
            super.onMessageReceived( messageEvent );
        }

    }
}

