package com.example.bakingapp.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bakingapp.R;
import com.example.bakingapp.model.RecipesModel;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.ViewHolder> {
    Context mContext;
    RecyclerView mRecyclerView;
    List<RecipesModel> mRecipes;


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView name;
        public TextView servings;
        public ImageView image;
        public int id;

        public ViewHolder(View view) {
            super(view);
            itemView = view;
//            name = itemView.findViewById(R.id.textview_movie_name);
//            servings = itemView.findViewById(R.id.textview_movie_rating);
//            image = itemView.findViewById(R.id.imageview_movie_poster);
        }
    }

    public RecipesAdapter(Context context, List<RecipesModel> recipes, RecyclerView rv) {
        super();
        mRecipes = recipes;
        mContext = context;
        mRecyclerView = rv;
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(context, 1));
    }

    @Override
    public int getItemCount() {
        return mRecipes == null ? 0 : mRecipes.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View recipeView = inflater.inflate(R.layout.recipe_list_item, parent, false);
        return new ViewHolder(recipeView);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        PopularMoviesModel movie = mPopularMovies.get(position);
//        holder.movieId = movie.id;
//        holder.movieTitle.setText(movie.title);
//        holder.movieRating.setText(Double.toString(movie.voteAverage));
//        String imgPath = getMovieDetailPosterPath(mContext, movie.posterPath, 400);
//        Picasso.get().load(imgPath).into(holder.moviePoster);
//
//        holder.itemView.setOnClickListener(view -> {
//            Bundle detailBundle = new Bundle();
//            detailBundle.putString(TITLE, movie.title);
//            detailBundle.putString(OVERVIEW, movie.overview);
//            detailBundle.putString(RELEASE_DATE, movie.releaseDate);
//            detailBundle.putString(RATING, movie.voteAverage.toString());
//            detailBundle.putString(POSTER_PATH, movie.posterPath);
//            detailBundle.putLong(MOVIE_ID, movie.id);
//            Intent movieDetailIntent = new Intent(mContext, MovieDetailActivity.class);
//            movieDetailIntent.putExtras(detailBundle);
//            (mContext).startActivity(movieDetailIntent);
//        });
    }

    public void addAll(List<RecipesModel> recipes) {
        mRecipes.addAll(recipes);
        notifyDataSetChanged();
    }

    public void clear() {
        mRecipes.clear();
        notifyDataSetChanged();
    }
}
