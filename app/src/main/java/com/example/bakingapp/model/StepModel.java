package com.example.bakingapp.model;

import com.google.gson.annotations.SerializedName;

public class StepModel {
    @SerializedName("id")
    public String id;
    @SerializedName("shortDescription")
    public String shortDescription;
    @SerializedName("description")
    public String description;
    @SerializedName("videoUrl")
    public String videoUrl;
    @SerializedName("thumbnailUrl")
    public String thumbnailUrl;
}
