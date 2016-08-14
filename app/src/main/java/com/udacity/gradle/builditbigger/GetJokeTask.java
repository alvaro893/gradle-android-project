/**
 * Copyright (C) 2016 Alvaro Bolanos Rodriguez
 */
package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.util.Log;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import es.alvaroweb.jokegcm.myApi.MyApi;

/*
 * TODO: Create JavaDoc
 */
public class GetJokeTask extends AsyncTask<Void, Void, String> {
    private static final String URL = "http://jokegcm.appspot.com/_ah/api/";
    private static final String DEBUG_TAG = GetJokeTask.class.getSimpleName();
    MyApi myApiService = null;
    private OnGetResultListener mListener;

    public GetJokeTask(OnGetResultListener mListener) {
        this.mListener = mListener;
    }

    @Override
    protected String doInBackground(Void... voids) {
        if(myApiService == null){
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null);
            builder.setRootUrl(URL);
            myApiService = builder.build();
        }

        try {
            String data = myApiService.getJoke().execute().getData();
            Log.d(DEBUG_TAG, data);
            return data;

        } catch (IOException e) {
            Log.d(DEBUG_TAG, e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        mListener.onGetResult(s);
    }

    public interface OnGetResultListener{
        void onGetResult(String s);
    }
}
