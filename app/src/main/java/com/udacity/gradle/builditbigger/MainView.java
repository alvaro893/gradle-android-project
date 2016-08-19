package com.udacity.gradle.builditbigger;

/**
 * Copyright (C) 2016 Alvaro Bolanos Rodriguez
 */
public interface MainView<T> {
    void setPresenter(T presenter);
    void openJokeActivity(String jokeString);
    void activateSpinner();
    void deactivateSpinner();
}
