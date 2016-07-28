/**
 * Copyright (C) 2016 Alvaro Bolanos Rodriguez
 */
package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;

import static junit.framework.Assert.*;

/*
 * TODO: Create JavaDoc
 */
@RunWith(AndroidJUnit4.class)
public class GetJokeTest {

    private static final String DEBUG_TAG = GetJokeTest.class.getSimpleName();
    private GetJokeTask mGetJokeTask;

    @Before
    public void init(){
        mGetJokeTask = new GetJokeTask(createListener());
    }


    @Test
    public void testGetJoke() throws ExecutionException, InterruptedException {
        mGetJokeTask.execute();
        String joke = mGetJokeTask.get();
        Log.d(DEBUG_TAG, "string recieved: " + joke);
        assertFalse("should be not a empty string", joke.isEmpty());
    }

    private GetJokeTask.OnGetResultListener createListener() {
        return new GetJokeTask.OnGetResultListener() {
            @Override
            public void onGetResult(String s) {

            }
        };
    }
}
