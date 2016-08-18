package com.udacity.gradle.builditbigger.flavors.paid;

import android.os.Bundle;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.MainActivity;

/**
 * Created by alvarob on 14.8.2016.
 */
public class MainActivityPaid extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(MainActivityPaid.this, "hello form paid", Toast.LENGTH_SHORT).show();
    }
}
