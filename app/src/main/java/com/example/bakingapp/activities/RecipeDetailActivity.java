package com.example.bakingapp.activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.bakingapp.constants.RecipeDetailConstants;
import com.example.bakingapp.fragments.RecipeDetailFragment;
import com.example.bakingapp.R;
import com.example.bakingapp.model.IngredientModel;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.widget.Toolbar;

import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.view.MenuItem;

import java.util.ArrayList;

import static com.example.bakingapp.constants.RecipeDetailConstants.INGREDIENTS;

public class RecipeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            Intent intent = getIntent();
            arguments.putString(RecipeDetailConstants.NAME,
                    intent.getStringExtra(RecipeDetailConstants.NAME));
            ArrayList<IngredientModel> li = (ArrayList<IngredientModel>) intent.getBundleExtra("BUNDLE").getSerializable(RecipeDetailConstants.INGREDIENTS);
            arguments.putSerializable(INGREDIENTS, li);
            RecipeDetailFragment fragment = new RecipeDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(new Intent(this, RecipeListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}