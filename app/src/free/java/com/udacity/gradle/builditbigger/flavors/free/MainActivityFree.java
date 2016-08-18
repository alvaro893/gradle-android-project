package com.udacity.gradle.builditbigger.flavors.free;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.udacity.gradle.builditbigger.MainActivity;
import com.udacity.gradle.builditbigger.MainPresenter;
import com.udacity.gradle.builditbigger.MainView;
import com.udacity.gradle.builditbigger.R;

import butterknife.ButterKnife;

public class MainActivityFree extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        Toast.makeText(mContext, "hello from free", Toast.LENGTH_SHORT).show();

        // create presenter using the fragment for the free version
        new MainPresenter((MainView) getSupportFragmentManager().findFragmentById(R.id.fragmentFree));
    }
}
