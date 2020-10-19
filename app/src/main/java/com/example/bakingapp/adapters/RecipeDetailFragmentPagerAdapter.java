package com.example.bakingapp.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.bakingapp.fragments.RecipeDetailPageTabFragment;

public class RecipeDetailFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String[] mTabTitles = new String[] { "Ingredients", "Steps"  };
    private Context mContext;

    public RecipeDetailFragmentPagerAdapter (FragmentManager fm, Context context) {
        super(fm);
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return RecipeDetailPageTabFragment.newInstance(mTabTitles[position]);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return mTabTitles[position];
    }
}
