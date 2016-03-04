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

    public MobileArrayAdapter(Context context, String[] values) {
        super(context, R.layout.my_list, values);
        this.context = context;
        this.values = values;
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




        // Change icon based on name
        String s = values[position];

        System.out.println(s);

        if (s.equals("Barbara Boxer")) {
            imageView.setImageResource(R.drawable.boxer);


            textView2.setText("Democrat");
            textView3.setText("bboxer@gmail.com");
            textView4.setText("https://boxer.senate.gov/");
            textView5.setText("Justice delayed is justice denied. #DoYourJob ");

        } else if (s.equals("Mike Honda")) {
            imageView.setImageResource(R.drawable.mikehonda);

            textView2.setText("Democrat");
            textView3.setText("google.com/+mikehonda");
            textView4.setText("https://honda.house.gov/");
            textView5.setText(" 'We do not want to make a mistake as nation who believes in the rule of law.' to the @FBI Director about the #Apple case.");

        } else if (s.equals("Barbara Lee")) {
            imageView.setImageResource(R.drawable.barbaralee);
            textView2.setText("Democrat");
            textView3.setText("blee@gmail.com");
            textView4.setText("https://lee.house.gov/");
            textView5.setText("ICYMI: The @mlkfreedomctr will live stream the Barbara Lee & Elihu Harris lecture w/ @bobbyseale tonight at 6:45pm. Don’t miss it!");

        } else if (s.equals("Diane Feinstein")) {
            imageView.setImageResource(R.drawable.californiasenator);
            textView2.setText("Democrat");
            textView3.setText("dfeinstein@gmail.com");
            textView4.setText("https://feinstein.senate.gov/");
            textView5.setText("Always great to meet with the California Cut Flower Commission. 75% of domestic flowers come from California! ");

        } else if (s.equals("Anna Eshoo")) {
            imageView.setImageResource(R.drawable.annaeshoo);
            textView2.setText("Democrat");
            textView3.setText("aeshoo@gmail.com");
            textView4.setText("https://eshoo.house.gov/");
            textView5.setText("ICYMI: My statement on the Apple court order. http://goo.gl/yJER50");

        }

        return rowView;
    }


}