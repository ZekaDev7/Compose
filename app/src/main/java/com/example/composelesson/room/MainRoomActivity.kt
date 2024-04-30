package com.example.composelesson.room

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
fun RoomPage() {
    val context = LocalContext.current
    val db = PersonDatabase.accessToDatabase(context)!!

    LaunchedEffect(key1 = true) {
        randomPerson(db)
        deletePerson(db)
        updatePerson(db)
        addPerson(db)
        getAllPersons(db)
        searchPersons(db)
        getPersonById(db)
    }
}

fun getAllPersons(db: PersonDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
//        val personList = db.dao().getAllPersons()
    }
}

fun addPerson(db: PersonDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val newPerson = Entity(0, "zeka", "0000000")
//        db.dao().addPerson(newPerson)
    }
}

fun updatePerson(db: PersonDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val updatePerson = Entity(3, "new name", "4444444")
//        db.dao().updatePerson(updatePerson)
    }
}

fun deletePerson(db: PersonDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
        val deletePerson = Entity(3, "", "")
//        db.dao().deletePerson(deletePerson)
    }
}

fun randomPerson(db: PersonDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
//        val personList = db.dao().getRandomPerson()
    }
}

fun searchPersons(db: PersonDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
//        val personList = db.dao().searchPersons("anything")
    }
}

fun getPersonById(db: PersonDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
//        val person = db.dao().getPersonById(1)
//
//        Log.e("Person id", person.personId.toString())
//        Log.e("Person name", person.personName)
//        Log.e("Person phone number", person.personPhoneNumber)
    }
}

fun saveControl(db: PersonDatabase) {
    val job: Job = CoroutineScope(Dispatchers.Main).launch {
//        val result = db.dao().saveControl("zeka")
//
//        Log.e("Person result", result.toString())
    }
}