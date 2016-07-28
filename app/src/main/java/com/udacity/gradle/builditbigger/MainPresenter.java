/**
 * Copyright (C) 2016 Alvaro Bolanos Rodriguez
 */
package com.udacity.gradle.builditbigger;

import android.support.annotation.NonNull;

/*
 * TODO: Create JavaDoc
 */
public class MainPresenter {
    private static final String DEBUG_TAG = MainPresenter.class.getSimpleName();

    @NonNull
    private MainView mView;

    public MainPresenter(@NonNull MainView mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    public void fetchJoke(){
        EndPointTask endPointTask = new EndPointTask(new EndPointTask.OnGetResultListener() {
            @Override
            public void onGetResult(String s) {
                mView.openJokeActivity(s);
            }
        });
        endPointTask.execute();
    }
}
