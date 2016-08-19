package es.alvaroweb.andlibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static final String JOKE_ARG = "jokearg";
    private String mJoke;
    private TextView mJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        mJokeTextView = (TextView) findViewById(R.id.joke_text);
        Button jokebutton = (Button) findViewById(R.id.joke_button);
        jokebutton.setOnClickListener(setButton());

        setJoke();
    }

    private View.OnClickListener setButton() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        };
    }

    private void setJoke() {
        Bundle extras = getIntent().getExtras();
        mJoke = extras.getString(JOKE_ARG);
        mJokeTextView.setText(mJoke);
    }

}
