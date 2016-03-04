package com.example.hudaiftekhar.represent;

import android.content.Intent;
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

import com.example.hudaiftekhar.represent.MobileArrayAdapter;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.widget.TextView;



    public class CongressionalView extends ListActivity {


        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Bundle bundle = getIntent().getExtras();
            String val = bundle.getString("LOC_NAME"); // obtain number of calories

            if (val.equals("94704")) {

                final String[] MOBILE_OS = new String[] {"Barbara Boxer", "Diane Feinstein", "Barbara Lee"};
                setListAdapter(new MobileArrayAdapter(this, MOBILE_OS));
            }
            else if (val.equals("95051")) {
                final String[] MOBILE_OS = new String[] {"Barbara Boxer", "Diane Feinstein", "Mike Honda"};
                setListAdapter(new MobileArrayAdapter(this, MOBILE_OS));
            }
            else if (val.equals("94061")) {
                final String[] MOBILE_OS = new String[] {"Barbara Boxer", "Diane Feinstein", "Anna Eshoo"};
                setListAdapter(new MobileArrayAdapter(this, MOBILE_OS));
            }

             


        }

        @Override
        protected void onListItemClick(ListView l, View v, int position, long id) {

            //get selected items
            String selectedValue = (String) getListAdapter().getItem(position);
            Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();

            Intent sendIntent4 = new Intent(CongressionalView.this, DetailedView.class);
            sendIntent4.putExtra("name2", selectedValue);
            startActivity(sendIntent4);

        }



    }

