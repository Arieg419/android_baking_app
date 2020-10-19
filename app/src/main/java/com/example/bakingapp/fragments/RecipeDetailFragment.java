package com.example.bakingapp.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.bakingapp.R;
import com.example.bakingapp.activities.RecipeDetailActivity;
import com.example.bakingapp.activities.RecipeListActivity;
import com.example.bakingapp.adapters.RecipeDetailFragmentPagerAdapter;
import com.example.bakingapp.constants.RecipeDetailConstants;
import com.example.bakingapp.model.IngredientModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link RecipeListActivity}
 * in two-pane mode (on tablets) or a {@link RecipeDetailActivity}
 * on handsets.
 */
public class RecipeDetailFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private String mName;
    private ArrayList<IngredientModel> mIngredients;

    public RecipeDetailFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        assert b != null;
        mName = b.getString(RecipeDetailConstants.NAME);
        mIngredients = (ArrayList<IngredientModel>) b.getSerializable(RecipeDetailConstants.INGREDIENTS);
        assert mIngredients != null;
        for (IngredientModel ingredientModel: mIngredients ) {
            System.out.println("Omer recipeDetailFrag -> ingredient: " + ingredientModel.getIngredient()+ " q: " + ingredientModel.getQuantity()+ " measure: " + ingredientModel.getMeasure());
        }
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
        return inflater.inflate(R.layout.recipe_tabbed_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View rootView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(rootView, savedInstanceState);
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        viewPager.setAdapter(new RecipeDetailFragmentPagerAdapter(getChildFragmentManager(),
                getActivity()));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);
    }
}