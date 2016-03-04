package com.example.hudaiftekhar.represent;

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
// when buttons are pressed, they start the PhoneToWatchService
// with zip code/location passed in

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText textOne = (EditText) findViewById(R.id.editText);
        final String zipCode = textOne.getText().toString();

        Button buttonOne = (Button) findViewById(R.id.button);
        Button buttonTwo = (Button) findViewById(R.id.button2); // current location

    }

    public void sendNextScreen2(View v) {

        EditText textOne = (EditText) findViewById(R.id.editText);
        final String zipCode = textOne.getText().toString();

        // send to Congressional View
        Intent sendIntent4 = new Intent(MainActivity.this, CongressionalView.class);
        sendIntent4.putExtra("LOC_NAME", "94704");
        startActivity(sendIntent4);

        // sending info to Phone to Watch
        Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
        sendIntent.putExtra("LOC_NAME", "94704");
        startService(sendIntent);

    }

    public void sendNextScreen(View v) {

        EditText textOne = (EditText) findViewById(R.id.editText);
        final String zipCode = textOne.getText().toString();

        Intent sendIntent2 = new Intent(MainActivity.this, CongressionalView.class);
        sendIntent2.putExtra("LOC_NAME", zipCode);
        startActivity(sendIntent2);

        //making a  call to phone to watch
        Intent sendIntent = new Intent(getBaseContext(), PhoneToWatchService.class);
        sendIntent.putExtra("LOC_NAME", zipCode);
        startService(sendIntent);

    }
}
