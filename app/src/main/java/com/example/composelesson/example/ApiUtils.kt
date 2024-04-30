package com.example.composelesson.example

class ApiUtils {
    companion object {
        private const val BASE_URL = "http://anything.any.com/"

        fun getPersonsDaoInterface(): PersonsDaoExamp {
            return RetrofitClient.getClient(BASE_URL).create(PersonsDaoExamp::class.java)
        }
    }
}