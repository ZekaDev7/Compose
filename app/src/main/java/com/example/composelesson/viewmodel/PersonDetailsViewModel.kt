package com.example.composelesson.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.composelesson.repo.PersonRepository

class PersonDetailsViewModel(application: Application): AndroidViewModel(application) {
    var repo = PersonRepository(application)

}