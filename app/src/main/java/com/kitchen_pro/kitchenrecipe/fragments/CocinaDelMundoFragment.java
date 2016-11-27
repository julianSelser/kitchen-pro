package com.kitchen_pro.kitchenrecipe.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kitchen_pro.kitchenrecipe.R;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.OnClick;


public class CocinaDelMundoFragment extends BaseFragment {

    @BindView(R.id.textViewInboxFragment)
    TextView textViewInboxFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        return view;
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.fragment_cocina_del_mundo;
    }

    @BindColor(R.color.md_yellow_800)
    int colorYellow;

    @OnClick(R.id.buttonFragmentInbox)
    public void onFragmentInboxButtonClick(Button button) {
        textViewInboxFragment.setText("This is the Inbox Fragment");
        textViewInboxFragment.setTextColor(colorYellow);
    }

    @Override
    protected String getToolbarTitle() {
        return "Inbox";
    }

}