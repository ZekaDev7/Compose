package com.example.composelesson.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.composelesson.repo.PersonRepository

class PersonRegistrationViewModel(application: Application): AndroidViewModel(application) {
    var repo = PersonRepository(application)

    fun registerPerson(name: String, phoneNumber: String) {
        repo.registerPerson(name, phoneNumber)
    }
}