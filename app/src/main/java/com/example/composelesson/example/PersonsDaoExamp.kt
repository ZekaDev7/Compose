package com.example.composelesson.example

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface PersonsDaoExamp {
    @GET("persons/all_persons.php")
    fun allPersons(): Call<ExampleDataClassResponse>

    @POST("persons/all_persons_search.php")
    @FormUrlEncoded // for language exchange
    fun searchPerson(@Field("personName") personName: String): Call<ExampleDataClassResponse>

    @POST("persons/all_persons_delete.php")
    @FormUrlEncoded // for language exchange
    fun deletePerson(@Field("personId") personId: Int): Call<CrudResponse>

    @POST("persons/insert_persons.php")
    @FormUrlEncoded // for language exchange
    fun insertPersons(@Field("personName") personName: String, @Field("personPhone") personPhone: String): Call<CrudResponse>

    @POST("persons/update_persons.php")
    @FormUrlEncoded // for language exchange
    fun updatePersons(@Field("personId") personId: Int,
                      @Field("personName") personName: String,
                      @Field("personPhone") personPhone: String): Call<CrudResponse>
}