package com.flashcards.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.flashcards.dao.QuestionDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

@Database(entities = [Question::class], version = 1, exportSchema = false)

abstract class QuestionDatabase : RoomDatabase(){

    abstract fun questionDao() : QuestionDao

    companion object{

        private var INSTANCE : QuestionDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope) : QuestionDatabase? {
            if (INSTANCE == null){
                synchronized(QuestionDatabase::class){
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        QuestionDatabase::class.java,
                        "QuestionDatabase")
                        .addCallback(QuestionDatabaseCallBack(scope))
                        .build()
                }
            }
            return INSTANCE
        }

        private class QuestionDatabaseCallBack(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override  fun onOpen(db: SupportSQLiteDatabase){
                super.onOpen(db)
                INSTANCE?.let{database ->
                    scope.launch(Dispatchers.IO){
                        populateDatabase(database.questionDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(questionDao: QuestionDao){
            var question = Question(1, "Singleton"," Design pattern which restricts a class to instantiate its multiple objects.")
            questionDao.insert(question)
            question = Question(2, "Collections","Group of individual objects represented as a single unit.")
            questionDao.insert(question)
            question = Question(3, "Thread","A thread of execution in a program.")
            questionDao.insert(question)
            question = Question(4, "Object Oriented Programming","A concepts in Java work by letting programmers create components that can be re-used in different ways, but still maintain security. Four main concepts are an abstraction, encapsulation, inheritance, and polymorphism.")
            questionDao.insert(question)
            question = Question(5, "Finally","Contains all the crucial statements that must be executed whether exception occurs or not. The statements present in this block will always execute regardless of whether exception occurs in try block or not such as closing a connection, stream etc.")
            questionDao.insert(question)
            question = Question(6, "Activity","The Activity class is a crucial component of an Android app, and the way activities are launched and put together is a fundamental part of the platform's application model. Unlike programming paradigms in which apps are launched with a main() method, the Android system initiates code in an Activity instance by invoking specific callback methods that correspond to specific stages of its lifecycle.")
            questionDao.insert(question)
            question = Question(7, "Service","World")
            questionDao.insert(question)
            question = Question(8, "Broadcast Receiver","World")
            questionDao.insert(question)
            question = Question(9, "Fragments","World")
            questionDao.insert(question)
            question = Question(10, "MVVM","World")
            questionDao.insert(question)
            question = Question(11, "JetPack","World")
            questionDao.insert(question)
            question = Question(12, "GSON","World")
            questionDao.insert(question)
            question = Question(13, "Moshi","World")
            questionDao.insert(question)
            question = Question(14, "ViewModel","World")
            questionDao.insert(question)
            question = Question(15, "RxJava","World")
            questionDao.insert(question)
            question = Question(16, "AsyncTask","World")
            questionDao.insert(question)
            question = Question(17, "Navigation","World")
            questionDao.insert(question)
            question = Question(18, "DataBinding","World")
            questionDao.insert(question)
            question = Question(19, "Room","World")
            questionDao.insert(question)
            question = Question(20, "WorkManager","World")
            questionDao.insert(question)
            question = Question(21, "Retrofit","World")
            questionDao.insert(question)
            question = Question(22, "Main Thread","World")
            questionDao.insert(question)
            question = Question(23, "Intent","World")
            questionDao.insert(question)
            question = Question(24, "Explicit Intent","World")
            questionDao.insert(question)
            question = Question(25, "Implicit Intent","World")
            questionDao.insert(question)
            question = Question(26, "Junit","World")
            questionDao.insert(question)
            question = Question(27, "Espresso","World")
            questionDao.insert(question)
            question = Question(28, "Mockito","World")
            questionDao.insert(question)
            question = Question(29, "Robolectric","World")
            questionDao.insert(question)
            question = Question(30, "Gradle","World")
            questionDao.insert(question)
            question = Question(31, "View","World")
            questionDao.insert(question)
            question = Question(32, "OkHttp","World")
            questionDao.insert(question)
            question = Question(33, "Volley","World")
            questionDao.insert(question)
            question = Question(34, "Glide","World")
            questionDao.insert(question)
            question = Question(35, "Piccasso","World")
            questionDao.insert(question)
            question = Question(36, "Coil","World")
            questionDao.insert(question)
            question = Question(37, "Module","World")
            questionDao.insert(question)
            question = Question(38, "Access Modifiers","World")
            questionDao.insert(question)
            question = Question(39, "Val","World")
            questionDao.insert(question)
            question = Question(40, "Var","World")
            questionDao.insert(question)
            question = Question(41, "lateInit","World")
            questionDao.insert(question)
            question = Question(42, "Lazy","World")
            questionDao.insert(question)
            question = Question(43, "Extension Functions","World")
            questionDao.insert(question)
            question = Question(44, "Android Extensions","World")
            questionDao.insert(question)
            question = Question(45, "Coroutines","World")
            questionDao.insert(question)
            question = Question(46, "Data Class","World")
            questionDao.insert(question)
            question = Question(47, "Infix","World")
            questionDao.insert(question)
            question = Question(48, "Inline","World")
            questionDao.insert(question)
            question = Question(49, "Visibility Modifier","World")
            questionDao.insert(question)
            question = Question(50, "Classes and Inheritance","World")
            questionDao.insert(question)
            question = Question(51, "?","World")
            questionDao.insert(question)
            question = Question(52, "!!","World")
            questionDao.insert(question)

        }
    }
}
