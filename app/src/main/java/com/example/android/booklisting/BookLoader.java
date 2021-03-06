package com.example.android.booklisting;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by hp2 on 08-01-2018.
 */

public class BookLoader extends AsyncTaskLoader<List<Book>> {



        private static final String LOG_TAG =BookLoader.class.getName();

        private String mUrl;

        public  BookLoader(Context context, String url) {
            super(context);
            // TODO: Finish implementing this constructor
            mUrl = url;

        }

        @Override
        protected void onStartLoading() {
            Log.i(LOG_TAG,"Test: onStartLoading() called");
            forceLoad();



        }

        @Override
        public List<Book> loadInBackground(){

            Log.i(LOG_TAG,"Test: loadInBackground() called");
            if (mUrl == null) {
                return null;
            }

            // Perform the network request, parse the response, and extract a list of earthquakes.
            List<Book> books = QueryUtils.fetchBookData(mUrl);
            return books;
        }


    }
