package com.flashcards

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import com.flashcards.dao.QuestionDao

class MainActivity : AppCompatActivity() {

    private var showingBack = false
    private lateinit var questionViewModel : QuestionViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null ){
            supportFragmentManager.beginTransaction()
                .add(R.id.container, QuestionFragment())
                .commit()
        }

        questionViewModel = ViewModelProvider(this).get(QuestionViewModel::class.java)

        question_btn.setOnClickListener{
            Toast.makeText(this,"Question Button Clicked", Toast.LENGTH_LONG).show()
//            tvAnswer.visibility = View.INVISIBLE
            questionViewModel.allQuestion.observe(this, Observer {
                var oldRand : Int = -1
                var rand = (it.indices).random()
                while (rand == oldRand){
                    rand = (it.indices).random()
                }
                if (rand != oldRand){
//                    QuestionFragment.tvQuestion.text = it[rand].question
//                    AnswerFragment.tvAnswer.text = it[rand].answer
                    oldRand = rand
                }
            })
        }

        answer_btn.setOnClickListener{
            Toast.makeText(this,"Answer Button Clicked", Toast.LENGTH_SHORT).show()
            flipCard()
        }


    }// end onCreate

    private fun flipCard() {
        if (showingBack) {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.card_flip_right_in,
                    R.anim.card_flip_right_out,
                    R.anim.card_flip_left_in,
                    R.anim.card_flip_left_out
                )
                .replace(R.id.container, QuestionFragment())
                .addToBackStack(null)
                .commit()
            showingBack = false
            answer_btn.text = "Show Answer"
        } else {
            supportFragmentManager.beginTransaction()
                .setCustomAnimations(
                    R.anim.card_flip_right_in,
                    R.anim.card_flip_right_out,
                    R.anim.card_flip_left_in,
                    R.anim.card_flip_left_out
                )
                .replace(R.id.container, AnswerFragment())
                .addToBackStack(null)
                .commit()
            showingBack = true
            answer_btn.text = "Show Question"
        }
    }


}
