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
import java.util.ArrayList;

public class CongressionalAdapter extends FragmentGridPagerAdapter {


        private final Context mContext;
        private List mRows;
        private String lengthArray;
        private String[] rNames;
        private String[] pNames;
        private String usState;
        private String pObama;
        private String pRomney;
        private String countyOne;
        private Page[][] PAGES;


        public CongressionalAdapter(Context ctx, FragmentManager fm, String length, String[] repNames, String[] partyNames, String state, String county, String perObama, String perRomney, String[] array1, String[] array2, String[] array3) {
            super(fm);
            mContext = ctx;
            this.lengthArray = length;
            this.rNames = repNames;
            this.pNames = partyNames;
            this.usState = state;
            this.pObama = perObama;
            this.pRomney = perRomney;
            this.countyOne = county;

            int length1 = Integer.parseInt(lengthArray);
            PAGES = new Page[length1+1][1];
            for (int i = 0; i < length1; i++) {
                PAGES[i][0] = new Page("Congressional View", rNames[i], pNames[i]," "," ", array1[i], array2[i], array3[i]);
            }
            PAGES[length1][0] = new Page("2012 Vote View", usState, countyOne, "Percentage Obama: " + pObama, "Percentage Romney: " + pRomney, " ", " ", " ");


        }


    /*
     *
        pager.setAdapter(new CongressionalAdapter(this, getFragmentManager(), catName, repNames, partyNames, state, obama, romney
      * */


        // A simple container for static data in each page
        private static class Page {
            // static resources
            String nameOne;
            String nameTwo;
            String nameThree;
            String nameFour;
            String nameFive;
            String nameSix;
            String nameSeven;
            String nameEight;

            public  Page(String name, String name2, String name3, String name4, String name5, String name6, String name7, String name8) {
                this.nameOne = name;
                this.nameTwo = name2;
                this.nameThree = name3;
                this.nameFour = name4;
                this.nameFive = name5;
                this.nameSix = name6;
                this.nameSeven = name7;
                this.nameEight = name8;
            }
        }

        // Create a static set of pages in a 2D array

        public Fragment getFragment(int row, int col) {

            Page page = PAGES[row][col];
            String title =  page.nameOne;
            String titleTwo = page.nameTwo;
            String titleThree = page.nameThree;
            String titleFour = page.nameFour;
            String titleFive = page.nameFive;

            ClickFragment fragment = ClickFragment.newInstance(title, titleTwo, titleThree, titleFour, titleFive, page.nameSix, page.nameSeven, page.nameEight);

            return fragment;
        }

        @Override
        public Drawable getBackgroundForPage(int row, int column) {
           /* if( row == 2 && column == 1) {
                // Place image at specified position
                return mContext.getResources().getDrawable(R.drawable.image_one, null);
            } else {*/
                // Default to background image for row
                return GridPagerAdapter.BACKGROUND_NONE;
          //  }
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


