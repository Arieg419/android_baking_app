package com.example.bakingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bakingapp.R;

public class RecipeDetailPageTabFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String ARG_INGREDIENTS = "ARG_INGREDIENTS ";

    private CharSequence mPage;

    public static RecipeDetailPageTabFragment newInstance(CharSequence title) {
        Bundle args = new Bundle();
        args.putCharSequence(ARG_PAGE, title);
        RecipeDetailPageTabFragment fragment = new RecipeDetailPageTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mPage = getArguments().getCharSequence(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recipe_fragment_tab_page, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.recipe_tab_non_static);
        textView.setText(mPage);
        TextView textView1 = (TextView) rootView.findViewById(R.id.recipe_tab_static);
        textView1.setText(mPage);
        return rootView;
    }

}
