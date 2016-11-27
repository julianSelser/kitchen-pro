package com.kitchen_pro.kitchenrecipe.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayoutResourceId(), container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    /**
     * When binding a fragment in onCreateView, set the views to null in onDestroyView.
     * ButterKnife returns an Unbinder on the initial binding that has an unbind method
     * to do this automatically.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * The Activity may have not been fully initialized yet in onCreateView.
     * In onActivityCreated there is no risk of getting a NullPointerException.
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        AppCompatActivity activity = (AppCompatActivity) getActivity();
        ActionBar actionBar = activity.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getToolbarTitle());
        }
    }

    protected String getToolbarTitle() {
        return "";
    }

    protected abstract int getLayoutResourceId();
}