package com.example.bakingapp.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bakingapp.fragments.RecipeDetailPageTabFragment;
import com.example.bakingapp.model.IngredientModel;

import java.util.ArrayList;

public class RecipeDetailFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String[] mTabTitles = new String[] { "Ingredients", "Steps"  };
    private Context mContext;
    private ArrayList<IngredientModel> mIngredientsList;
    private RecipeDetailIngredientsAdapter mRecipeIngredientsAdapter;

    public RecipeDetailFragmentPagerAdapter (FragmentManager fm, Context context, ArrayList<IngredientModel> ingredientList) {
        super(fm);
        this.mIngredientsList = ingredientList;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return RecipeDetailPageTabFragment.newInstance(mTabTitles[position], mIngredientsList);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return mTabTitles[position];
    }
}
