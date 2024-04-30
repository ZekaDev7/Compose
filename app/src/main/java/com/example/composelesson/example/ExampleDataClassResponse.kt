package com.example.composelesson.example

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ExampleDataClassResponse(
    @SerializedName("persons") @Expose var persons: List<ExampleDataClass>,
    @SerializedName("success") @Expose var success: Int
)
