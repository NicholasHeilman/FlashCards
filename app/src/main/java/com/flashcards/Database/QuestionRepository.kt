package com.flashcards.Database

import android.app.Application
import androidx.lifecycle.LiveData
import com.flashcards.dao.QuestionDao

class QuestionRespository(private val questionDao: QuestionDao) {


    val allQuestion: LiveData<List<Question>> = questionDao.getQuestion()

    suspend fun insert(q: Question){
        questionDao.insert(q)
    }
}