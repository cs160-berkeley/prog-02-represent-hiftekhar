package com.example.hudaiftekhar.represent;

/**
 * Created by hudaiftekhar on 3/1/16.
 */

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.wearable.view.CardFragment;
import android.support.wearable.view.FragmentGridPagerAdapter;
import android.support.wearable.view.GridPagerAdapter;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import android.support.wearable.view.GridViewPager;
import java.util.List;
import android.app.FragmentManager;
import android.app.Fragment;


public class CongressionalAdapter extends FragmentGridPagerAdapter {

    private final Context mContext;
    private List mRows;
    private String zipCodeVal;

    public CongressionalAdapter(Context ctx, FragmentManager fm, String catName) {
        super(fm);
        mContext = ctx;
        zipCodeVal = catName;
        }

    static final int[] BG_IMAGES = new int[] {
        R.drawable.mikehonda,
        R.drawable.boxer,
        R.drawable.californiasenator,
        };

// A simple container for static data in each page
    private static class Page {
        // static resources
        String name;
        String party;

        public  Page(String name, String party) {
        this.name = name;
            this.party = party;
        }
    }

// Create a static set of pages in a 2D array

    private final Page[][] PAGES = {{new Page("Barbara Boxer", "Democrat")}, {new Page("Diane Feinstein", "Democrat")}, {new Page("Barbara Lee", "Democrat")}, {new Page("2012 Berkeley CA" ,
            "Obama xx% of vote\n" +
            "Romney xx% of vote")}};
    private final Page[][] PAGES2 = {{new Page("Barbara Boxer", "Democrat")}, {new Page("Diane Feinstein", "Democrat")}, {new Page("Mike Honda", "Democrat")}, {new Page("2012 Santa Clara CA",
            "Obama xx% of vote\n" +
                    "Romney xx% of vote")}};
    private final Page[][] PAGES3 = {{new Page("Barbara Boxer", "Democrat")}, {new Page("Diane Feinstein", "Democrat")}, {new Page("Anna Eshoo", "Democrat")}, {new Page("2012 RedWood County CA",
            "Obama xx% of vote\n" +
                    "Romney xx% of vote")}};

    public Fragment getFragment(int row, int col) {
        if (Integer.parseInt(zipCodeVal) == 95051) {
            Page page = PAGES2[row][col];
            String title =  page.name;
            String partyName = page.party;
            ClickFragment fragment = ClickFragment.newInstance(title, partyName, title);

            return fragment;
        }
        else if (Integer.parseInt(zipCodeVal) == 94061) {
            Page page = PAGES[row][col];
            String title =  page.name;
            String partyName = page.party;
            ClickFragment fragment = ClickFragment.newInstance(title, partyName, title);

            return fragment;
        }
        else if (Integer.parseInt(zipCodeVal) == 94704) {
            Page page = PAGES3[row][col];
            String title =  page.name;
            String partyName = page.party;
            ClickFragment fragment = ClickFragment.newInstance(title, partyName, title);

            return fragment;
        }

        ClickFragment fragment = ClickFragment.newInstance("yo", "yo", "yo");
        return fragment;
    }

    @Override
    public Drawable getBackgroundForPage(int row, int column) {
        if( row == 2 && column == 1) {
        // Place image at specified position
        return mContext.getResources().getDrawable(R.drawable.image_one, null);
        } else {
        // Default to background image for row
        return GridPagerAdapter.BACKGROUND_NONE;
        }
        }

    @Override
    public int getRowCount() {
        return PAGES.length;
    }

    // Obtain the number of pages (horizontal)
    @Override
    public int getColumnCount(int rowNum) {
        return PAGES[rowNum].length;
    }
}

