package com.example.composelesson.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Entity::class], version = 1)
abstract class PersonDatabase : RoomDatabase() {
    abstract fun dao(): PersonDao

    companion object {
        var INSTANCE: PersonDatabase? = null

        fun accessToDatabase(context: Context): PersonDatabase? {
            if (INSTANCE == null) {
                synchronized(PersonDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        PersonDatabase::class.java,
                        ""
                    ).createFromAsset("").build()
                }
            }
            return INSTANCE
        }
    }
}