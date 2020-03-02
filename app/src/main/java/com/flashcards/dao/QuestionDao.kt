package com.flashcards.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.flashcards.Database.Question

@Dao
interface QuestionDao {

    @Query( "SELECT * FROM Question")
    fun getQuestion(): LiveData<List<Question>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(question: Question)

    @Update
    fun updateQuestion(question: Question)

    @Delete
    fun deleteQuestion(question: Question)

}