package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import es.alvaroweb.Joke;
import es.alvaroweb.andlibrary.JokeActivity;
import es.alvaroweb.jokegcm.myApi.MyApi;


public class MainActivity extends AppCompatActivity  {

    private static final String DEBUG_TAG = MainActivity.class.getSimpleName();
    private Context mContext;
    private EndPointTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        task = new EndPointTask();
                task.execute();

    }

    class EndPointTask extends AsyncTask<Void, Void, Void>{
        MyApi myApiService = null;


        @Override
        protected Void doInBackground(Void... voids) {
            if(myApiService == null){
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null);
                builder.setRootUrl("http://10.0.2.2:8080/_ah/api/");
                builder.setApplicationName("test");
                builder.setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                        request.setDisableGZipContent(true);
                    }
                });
                myApiService = builder.build();
            }

            try {
                String data = myApiService.getJoke().execute().getData();
                Log.d(DEBUG_TAG, data);

                Intent intent = new Intent(mContext, JokeActivity.class);
                intent.putExtra(JokeActivity.JOKE_ARG, data);
                startActivity(intent);

            } catch (IOException e) {
                Log.d(DEBUG_TAG, e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }


}
