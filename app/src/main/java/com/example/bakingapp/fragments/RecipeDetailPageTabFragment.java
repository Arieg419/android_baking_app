package com.example.bakingapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.R;
import com.example.bakingapp.activities.RecipeDetailActivity;
import com.example.bakingapp.adapters.RecipeDetailIngredientsAdapter;
import com.example.bakingapp.model.IngredientModel;

import java.util.ArrayList;

public class RecipeDetailPageTabFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String ARG_INGREDIENTS = "ARG_INGREDIENTS ";

    private CharSequence mPage;
    private ArrayList<IngredientModel> mIngredients;

    public static RecipeDetailPageTabFragment newInstance(CharSequence title, ArrayList<IngredientModel> ingredientList) {
        Bundle args = new Bundle();
        args.putCharSequence(ARG_PAGE, title);
        args.putSerializable("ingredients", ingredientList);
        RecipeDetailPageTabFragment fragment = new RecipeDetailPageTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        assert getArguments() != null;
        mPage = getArguments().getCharSequence(ARG_PAGE);
        mIngredients = getArguments().getParcelableArrayList("ingredients");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recipe_fragment_tab_page, container, false);
        RecyclerView ingredientsRv = rootView.findViewById(R.id.ingredient_list_rv);
        ingredientsRv.setHasFixedSize(true);
        ingredientsRv.setLayoutManager(new LinearLayoutManager(getContext()));
        ingredientsRv.setAdapter(new RecipeDetailIngredientsAdapter((RecipeDetailActivity) getActivity(), getContext(), mIngredients));
//        TextView textView = (TextView) rootView.findViewById(R.id.recipe_tab_non_static);
//        textView.setText(mPage);
//        TextView textView1 = (TextView) rootView.findViewById(R.id.recipe_tab_static);
//        textView1.setText(mPage);
        return rootView;
    }

}
