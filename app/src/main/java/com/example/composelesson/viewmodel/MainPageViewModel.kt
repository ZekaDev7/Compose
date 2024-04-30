package com.example.composelesson.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.composelesson.repo.PersonRepository
import com.example.composelesson.room.Entity

class MainPageViewModel(application: Application): AndroidViewModel(application) {
    var repo = PersonRepository(application)
    var personList = MutableLiveData<List<Entity>>()

    init {
        loadPerson()
        personList = repo.bringPerson()
    }

    fun loadPerson() {
        repo.getAllPerson()
    }
}