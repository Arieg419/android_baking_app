package com.example.bakingapp.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bakingapp.R;
import com.example.bakingapp.activities.RecipeDetailActivity;
import com.example.bakingapp.activities.RecipeListActivity;
import com.example.bakingapp.constants.RecipeDetailConstants;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link RecipeListActivity}
 * in two-pane mode (on tablets) or a {@link RecipeDetailActivity}
 * on handsets.
 */
public class RecipeDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private String mName;

    public RecipeDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        assert b != null;
        mName = b.getString(RecipeDetailConstants.NAME);
        Activity activity = this.getActivity();
        assert activity != null;
        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(mName);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);
        if (mName != null) {
            ((TextView) rootView.findViewById(R.id.item_detail)).setText(mName);
        }
        return rootView;
    }
}