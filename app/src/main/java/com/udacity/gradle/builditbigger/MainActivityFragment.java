package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.alvaroweb.andlibrary.JokeActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainView<MainPresenter> {

    protected MainPresenter mPresenter;


    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);

        return root;
    }


    @Override
    public void setPresenter(MainPresenter presenter) {
        mPresenter = presenter;
    }

    @OnClick(R.id.joke_button)
    void jokeButtonClick(View v) {
        mPresenter.fetchJoke();
    }

    @Override
    public void openJokeActivity(String jokeString) {
        Intent intent = new Intent(getActivity(), JokeActivity.class);
        intent.putExtra(JokeActivity.JOKE_ARG, jokeString);
        startActivity(intent);
    }
}
