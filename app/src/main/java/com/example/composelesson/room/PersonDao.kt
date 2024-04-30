package com.example.composelesson.room

import androidx.room.Dao

@Dao
interface PersonDao {
//    @Query("SELECT * FROM persons")
//    suspend fun getAllPersons(): List<Entity>
//
//    @Insert
//    suspend fun addPerson(person: Entity)
//
//    @Update
//    suspend fun updatePerson(person: Entity)
//
//    @Delete
//    suspend fun deletePerson(person: Entity)
//
//    @Query("SELECT * FROM persons ORDER BY RANDOM() LIMIT 1")
//    suspend fun getRandomPerson(): List<Entity>
//
//    @Query("SELECT * FROM persons WHERE personName like '%' || :keyWord || '%'")
//    suspend fun searchPersons(keyWord: String): List<Entity>
//
//    @Query("SELECT * FROM persons WHERE personId = :personId")
//    suspend fun getPersonById(personId: Int): Entity
//
//    @Query("SELECT * FROM persons WHERE personName = :personName")
//    suspend fun saveControl(personName: String): Int
}