package com.flashcards.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val question: String,
    val answer: String
)