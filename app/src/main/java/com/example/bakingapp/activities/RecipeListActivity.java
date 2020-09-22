package com.example.bakingapp.activities;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.R;
import com.example.bakingapp.adapters.RecipesAdapter;
import com.example.bakingapp.api.ApiClient;
import com.example.bakingapp.api.ApiInterface;
import com.example.bakingapp.model.RecipeModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeListActivity extends AppCompatActivity {

    private ApiInterface mApiInterface;
    private boolean mTwoPane = false;
    private List<RecipeModel> mRecipes;
    private RecipesAdapter mRecipesAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());
        mApiInterface = ApiClient.getClient(this).create(ApiInterface.class);

        if (findViewById(R.id.item_detail_container) != null) {
            // will be present when large-screen layouts
            mTwoPane = true;
        }

        mRecyclerView = findViewById(R.id.item_list);
        fetchRecipes(mApiInterface.doGetRecipes());
    }

    private void fetchRecipes(Call<List<RecipeModel>> call) {
        RecipeListActivity ref = this;
        call.enqueue(new Callback<List<RecipeModel>>() {
            @Override
            public void onResponse(Call<List<RecipeModel>> call, Response<List<RecipeModel>> response) {
                List<RecipeModel> recipesData = response.body();
                if (recipesData == null) {
                    return;
                }
                mRecipes = recipesData;
                Context context = getApplicationContext();
                mRecipesAdapter = new RecipesAdapter(ref, context, mRecipes, mRecyclerView, mTwoPane);
                mRecyclerView.setAdapter(mRecipesAdapter);
                if (mTwoPane) {
                    mRecyclerView.setLayoutManager(new GridLayoutManager(context, 1));
                } else {
                    mRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
                }
            }

            @Override
            public void onFailure(Call<List<RecipeModel>> call, Throwable t) {
                call.cancel();
            }
        });
    }
}