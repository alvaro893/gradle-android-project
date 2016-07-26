package es.alvaroweb.andlibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_ARG = "jokearg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Bundle extras = getIntent().getExtras();
        String joke = extras.getString(JOKE_ARG);

        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }
}
