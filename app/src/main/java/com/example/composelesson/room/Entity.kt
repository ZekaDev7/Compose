package com.example.composelesson.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "persons")
data class Entity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo("personId") val personId: Int,
    @ColumnInfo @NotNull val personName: String,
    @ColumnInfo @NotNull val personPhoneNumber: String
)