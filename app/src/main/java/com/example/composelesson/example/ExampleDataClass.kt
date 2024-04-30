package com.example.composelesson.example

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ExampleDataClass(
    @SerializedName("person_id") @Expose val personId: Int,
    @SerializedName("person_name") @Expose val personName: String,
    @SerializedName("person_phone") @Expose val personPhone: String
)
