package com.example.composelesson.example

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun MainExamplePersonsPage() {
    LaunchedEffect(key1 = true) {
        allPersons()
    }
}


fun allPersons() {
    val personsDaoInterface = ApiUtils.getPersonsDaoInterface()

    personsDaoInterface.allPersons().enqueue(object : Callback<ExampleDataClassResponse> {
        override fun onResponse(
            call: Call<ExampleDataClassResponse>,
            response: Response<ExampleDataClassResponse>
        ) {
            val list = response.body()?.persons

            if (list != null) {
                for (p in list) {
                    Log.e("Persons info", "********")
                    Log.e("Persons id", p.personId.toString())
                    Log.e("Persons Name ", p.personName)
                    Log.e("Persons Phone", p.personPhone)
                }
            }
        }

        override fun onFailure(p0: Call<ExampleDataClassResponse>, p1: Throwable) {

        }
    })
}

fun searchPersons() {
    val personsDaoInterface = ApiUtils.getPersonsDaoInterface()

    personsDaoInterface.searchPerson("any letter or word")
        .enqueue(object : Callback<ExampleDataClassResponse> {
            override fun onResponse(
                call: Call<ExampleDataClassResponse>,
                response: Response<ExampleDataClassResponse>
            ) {
                val list = response.body()?.persons

                if (list != null) {
                    for (p in list) {
                        Log.e("Persons info", "********")
                        Log.e("Persons id", p.personId.toString())
                        Log.e("Persons Name ", p.personName)
                        Log.e("Persons Phone", p.personPhone)
                    }
                }
            }

            override fun onFailure(p0: Call<ExampleDataClassResponse>, p1: Throwable) {

            }
        })
}

fun deletePerson() {
    val personsDaoInterface = ApiUtils.getPersonsDaoInterface()

    personsDaoInterface.deletePerson(0).enqueue(object : Callback<CrudResponse> {
        override fun onResponse(call: Call<CrudResponse>, response: Response<CrudResponse>) {
            val message = response.body()?.message
            val success = response.body()?.success
            Log.e("Delete person", "Success: $success - Message: $message")
        }

        override fun onFailure(p0: Call<CrudResponse>, p1: Throwable) {

        }
    })
}

fun insertPerson() {
    val personsDaoInterface = ApiUtils.getPersonsDaoInterface()

    personsDaoInterface.insertPersons("any name", "any phone number").enqueue(object : Callback<CrudResponse> {
        override fun onResponse(call: Call<CrudResponse>, response: Response<CrudResponse>) {
            val message = response.body()?.message
            val success = response.body()?.success
            Log.e("Add person", "Success: $success - Message: $message")
        }

        override fun onFailure(p0: Call<CrudResponse>, p1: Throwable) {

        }
    })
}

fun updatePerson() {
    val personsDaoInterface = ApiUtils.getPersonsDaoInterface()

    personsDaoInterface.updatePersons(1,"any name", "any phone number").enqueue(object : Callback<CrudResponse> {
        override fun onResponse(call: Call<CrudResponse>, response: Response<CrudResponse>) {
            val message = response.body()?.message
            val success = response.body()?.success
            Log.e("Update person", "Success: $success - Message: $message")
        }

        override fun onFailure(p0: Call<CrudResponse>, p1: Throwable) {

        }
    })
}