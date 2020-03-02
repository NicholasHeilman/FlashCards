package com.flashcards

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.flashcards.Database.Question
import com.flashcards.Database.QuestionDatabase
import com.flashcards.Database.QuestionRepository

class QuestionViewModel (application: Application) : AndroidViewModel(application){

    private val repository: QuestionRepository
    val allQuestion: LiveData<List<Question>>

    init {
        val questionDao = QuestionDatabase.getDatabase(application, viewModelScope)?.questionDao()
        repository = questionDao?.let { QuestionRepository(it) }!!
        allQuestion = repository.allQuestion
    }

}