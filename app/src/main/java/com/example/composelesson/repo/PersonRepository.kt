package com.example.composelesson.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.composelesson.room.Entity
import com.example.composelesson.room.PersonDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PersonRepository(application: Application) {

    private var personList = MutableLiveData<List<Entity>>()
    val db: PersonDatabase

    init {
        db = PersonDatabase.accessToDatabase(application)!!
        personList = MutableLiveData()
    }

    fun bringPerson(): MutableLiveData<List<Entity>> {
        return personList
    }

    fun getAllPerson() {

        val job: Job = CoroutineScope(Dispatchers.Main).launch {
//            personList.value = db.dao().getAllPersons()
        }

//        val list = mutableListOf<Person>()
//        val p1 = Person(1, "name1", 25)
//        val p2 = Person(2, "name2", 12)
//
//        list.add(p1)
//        list.add(p2)
//
//        personList.value = list
    }

    fun searchPerson(searchName: String) {

    }

    fun registerPerson(name: String, phoneNumber: String) {

    }

    fun updatePerson() {

    }

    fun deletePerson() {

    }
}