package com.flashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import com.flashcards.dao.QuestionDao

class MainActivity : AppCompatActivity() {

//    private val newQuestionActivity = 1
    private lateinit var questionViewModel : QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        questionViewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)

        question_btn.setOnClickListener{
//            Toast.makeText(this,"Button Clicked", Toast.LENGTH_LONG).show()
            questionViewModel.allQuestion.observe(this, Observer {
                var oldRand : Int = -1
                var rand = (it.indices).random()

                while (rand == oldRand){
                    rand = (it.indices).random()
                }
                if (rand!= oldRand){
                tvQuestion.text = it[rand].question
                    oldRand = rand
                }
            })
        }
    }// end onCreate
}
