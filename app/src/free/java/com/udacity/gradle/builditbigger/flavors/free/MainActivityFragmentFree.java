package com.udacity.gradle.builditbigger.flavors.free;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.udacity.gradle.builditbigger.MainActivityFragment;
import com.udacity.gradle.builditbigger.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * This extends MainActivityFragment adding the ads
 */
public class MainActivityFragmentFree extends MainActivityFragment {
    @BindView(R.id.adView) AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // The fragment view is created in the father
        View root = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, root);
        doAdRequest(mAdView);
        return root;
    }

    private void doAdRequest(AdView adView){
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
    }
}
