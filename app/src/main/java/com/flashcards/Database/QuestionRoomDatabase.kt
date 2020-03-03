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
            question = Question(3, "Thread","An independent path of execution in a program.")
            questionDao.insert(question)
            question = Question(4, "Object Oriented Programming","A concepts in Java work by letting programmers create components that can be re-used in different ways, but still maintain security. Four main concepts are an abstraction, encapsulation, inheritance, and polymorphism.")
            questionDao.insert(question)
            question = Question(5, "Finally","Contains all the crucial statements that must be executed whether exception occurs or not. The statements present in this block will always execute regardless of whether exception occurs in try block or not such as closing a connection, stream etc.")
            questionDao.insert(question)
            question = Question(6, "Activity","The Activity class is a crucial component of an Android app, and the way activities are launched and put together is a fundamental part of the platform's application model. Unlike programming paradigms in which apps are launched with a main() method, the Android system initiates code in an Activity instance by invoking specific callback methods that correspond to specific stages of its lifecycle.")
            questionDao.insert(question)
            question = Question(7, "Service","This is an application component that can be used for long-running background processes. It is not bounded with any activity as there is no UI. Any other application component can start a service and this service will continue to run even when the user switches from one application to another")
            questionDao.insert(question)
            question = Question(8, "Broadcast Receiver","A component that enables the system to deliver events to the app outside of a regular user flow, allowing the app to respond to system-wide broadcast announcements such as notifications.")
            questionDao.insert(question)
            question = Question(9, "Fragments","Represents a behavior or a portion of user interfaced")
            questionDao.insert(question)
            question = Question(10, "MVVM","This pattern helps to cleanly separate the business and presentation logic of an application from its user interface. Maintaining a clean separation between application logic and the UI helps to address numerous development issues and can make an application easier to test, maintain, and evolve")
            questionDao.insert(question)
            question = Question(11, "JetPack","A suite of libraries, tools and guidance to help developers write high quality apps easier.\n" +
                    "Help developers follow best practices\n" +
                    "Free developers from writing boilerplate code\n" +
                    "Simplify complex tasks")
            questionDao.insert(question)
            question = Question(12, "GSON","An open-source Java library to serialize and deserialize Java objects to JSON")
            questionDao.insert(question)
            question = Question(13, "Moshi","a modern JSON library for Android and Java. It makes it easy to parse JSON into Java objects:")
            questionDao.insert(question)
            question = Question(14, "ViewModel","This implements properties and commands to which the view can data bind to, and notifies the view of any state changes through change notification events. The properties and commands that the view model provides define the functionality to be offered by the UI, but the view determines how that functionality is to be displayed")
            questionDao.insert(question)
            question = Question(15, "RxJava","This is a Java VM implementation of ReactiveX a library for composing asynchronous and event-based programs by using observable sequences. The building blocks for this are Observables and Subscribers")
            questionDao.insert(question)
            question = Question(16, "AsyncTask","This is an abstract android class which helps the android applications to handle the main UI thread in an efficient way. This class allows us to perform long lasting tasks/background operations and show the result on the UI thread without affecting the main thread.")
            questionDao.insert(question)
            question = Question(17, "Navigation","Occurs between your apps destinations, that is anywhere in your app to which users can navigate. Destinations are connected via actions.")
            questionDao.insert(question)
            question = Question(18, "DataBinding","a support library that allows you to bind UI components in your layouts to data sources in your app using a declarative format rather than programmatically.")
            questionDao.insert(question)
            question = Question(19, "Room","this is a persistence library that provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite. The library helps you create a cache, which serves as your app's single source of truth, allows users to view a consistent copy of key information within your app, regardless of whether users have an internet connection")
            questionDao.insert(question)
            question = Question(20, "WorkManager","API makes it easy to schedule deferrable, asynchronous tasks that are expected to run even if the app exits or device restarts.")
            questionDao.insert(question)
            question = Question(21, "Retrofit","(A type-safe HTTP client for Android and Java) Built by square and makes it easy to consume JSON or XML data which is parsed into Plain Old Java Objects (POJOs). It is also a REST client library that creates an HTTP request and also processes the HTTP response from a REST API.")
            questionDao.insert(question)
            question = Question(22, "Main Thread"," is responsible for dispatching events to the appropriate user interface widgets as well as communicating with components from the Android UI toolkit.")
            questionDao.insert(question)
            question = Question(23, "Intent","This is a messaging object which can be used to communicate between two or more components like activities, services, broadcast receiver etc. It can also be used to start an activity or service or to deliver broadcast messages.")
            questionDao.insert(question)
            question = Question(24, "Explicit Intent","Situation in which you know the target of that intent. Any other component can be specified. Only the target component will be invoked.")
            questionDao.insert(question)
            question = Question(25, "Implicit Intent","Situation in which you do not have the name of the target component, but have a general action to perform by this intent. The android operating system will filter out which component will provide a response to the action.")
            questionDao.insert(question)
            question = Question(26, "Junit","This is a unit testing framework for java. It has been important in the development of test-driven development and is one of a family of unit testing frameworks which is collectively known as xUnit that originated with SUnit. This is linked as a JAR at compile-time.")
            questionDao.insert(question)
            question = Question(27, "Espresso","This is a testing framework for Android to make it easy to write reliable user interface tests. This automatically synchronizes your test actions with the user interface of your application. It also ensures that your activity is started before the tests run.")
            questionDao.insert(question)
            question = Question(28, "Mockito","This is a mocking framework, JAVA-based library that is used for effective unit testing of java applications. It's used to mock interfaces so that a dummy functionality can be added to a mock interface that can be used in unit testing")
            questionDao.insert(question)
            question = Question(29, "Robolectric","a framework that brings fast and reliable unit tests to Android. Tests run inside the JVM on your workstation in seconds.")
            questionDao.insert(question)
            question = Question(30, "Gradle","This translates our instructions into a language that's easier for Android devices to understand, and compresses our translated instructions and resources into a file called an APK")
            questionDao.insert(question)
            question = Question(31, "View","This pattern contains the UI business logic for the view. All invocations from the view delegate directly to the presenter which is also decoupled directly from the view and talks to it through an interface. This tends to be a very natural pattern for achieving separated presentation in web forms")
            questionDao.insert(question)
            question = Question(32, "OkHttp","this is an android HTTP client library from Square that reduces the steps needed. It's a simple library to use, loading data faster and saving bandwidth. It also removed the need for network testing, recovering from common connection problems, and on a connection failure, this can retry the request with a different route.")
            questionDao.insert(question)
            question = Question(33, "Volley","Volley is a REST networking library it offers great features like  prioritization, ordered requests and of course caching, making multiple requests at the same time, asynchronous requests, synchronous requestsa")
            questionDao.insert(question)
            question = Question(34, "Glide"," This offers an easy to use API, a performant and extensible resource decoding pipeline and automatic resource pooling.")
            questionDao.insert(question)
            question = Question(35, "Piccasso","Image downloading and caching library created by the same creators of Retrofit.")
            questionDao.insert(question)
            question = Question(36, "Coil","An image loading library for Android backed by Kotlin Coroutines.")
            questionDao.insert(question)
            question = Question(37, "Module"," provide a container for your app's source code, resource files, and app level settings, such as the module-level build file and Android manifest file. Each module can be independently built, tested, and debugged.")
            questionDao.insert(question)
            question = Question(38, "Access Modifiers","The Modifier class provides static methods and constants to decode class and member access modifiers. The sets of modifiers are represented as integers with distinct bit positions representing different modifiers.")
            questionDao.insert(question)
            question = Question(39, "Val","(Value) An immutable value")
            questionDao.insert(question)
            question = Question(40, "Var","(Variable) Each of this has a name and contents of this can be changed by the android device as the app runs")
            questionDao.insert(question)
            question = Question(41, "lateInit","late initialization.")
            questionDao.insert(question)
            question = Question(42, "Lazy","lazy initialization. a function that takes a lambda and returns an instance of lazy which can serve as a delegate for implementing a lazy property")
            questionDao.insert(question)
            question = Question(43, "Extension Functions","provides the ability to extend a class with new functionality without having to inherit from the class or use design patterns such as Decorator")
            questionDao.insert(question)
            question = Question(44, "Android Extensions","allows us to obtain the same experience we have with some of these libraries, without having to add any extra code.")
            questionDao.insert(question)
            question = Question(45, "Coroutines","These are components that generalize subroutines for non-preemptive multitasking, by allowing execution to be suspended and resumed. These are well-suited for implementing familiar program components such as cooperative tasks, exceptions, event loops, iterators, infinite lists and pipes")
            questionDao.insert(question)
            question = Question(46, "Data Class","a concept not tied to any specific programming language, it’s a pattern that’s convenient enough to most programmers as a simple way to represent, encapsulate and move information around.")
            questionDao.insert(question)
            question = Question(47, "Infix","Functions marked with the infix keyword can also be called using the infix notation (omitting the dot and the parentheses for the call).")
            questionDao.insert(question)
            question = Question(48, "Inline","Using higher-order functions imposes certain runtime penalties: each function is an object, and it captures a closure, i.e. those variables that are accessed in the body of the function. Memory allocations (both for function objects and classes) and virtual calls introduce runtime overhead.")
            questionDao.insert(question)
            question = Question(49, "Visibility Modifier"," keywords that set the visibility (accessibility) of classes, objects, interface, constructors, functions, properties and their setters. (You cannot set visibility modifier of getters as they always take the same visibility as that of the property.)")
            questionDao.insert(question)
            question = Question(50, "Classes and Inheritance","World")
            questionDao.insert(question)
            question = Question(51, "?"," Added after the data type of that property which declares that variable as a nullable property ")
            questionDao.insert(question)
            question = Question(52, "!!","Null Check")
            questionDao.insert(question)
            question = Question(53, "XML","is used for designing the application's UI like creating layouts, views, buttons, text fields etc. and also used in parsing data feeds from the internet")
            questionDao.insert(question)
            question = Question(54, "View","is a UI which occupies rectangular area on the area to draw and handle user events")
            questionDao.insert(question)
            question = Question(55, "Interface","Blueprint of a class. It has static constants and abstract methods. In Java it is a mechanism to achieve abstraction. There can only be abstract methods in the Java interface, not method body. It is used to achieve abstraction and multiple inheritance in java")
            questionDao.insert(question)
            question = Question(56, "Layout","Parent of views. It arranges the views on the screen")
            questionDao.insert(question)
            question = Question(57, "Content Providers","manages a shared set of app data that you can store in the file system, in an SQLite database, on the web, or any other persistent storage location that your app can access. Essentially, they are used to share data between two applications.")
            questionDao.insert(question)
            question = Question(58, "Parcelable","this is the android implementation of the java serializable.")
            questionDao.insert(question)
            question = Question(59, "Software Development Kit (SDK)","A set of programming tools and resources built specifically to aid software development on a particular platform or technology")
            questionDao.insert(question)
            question = Question(60, "Resource Manager","Provides access to non-coded resources such as strings, color settings and user-interface layouts.")
            questionDao.insert(question)
            question = Question(61, "Sticky Intent","This intent is a broadcast from a sendStickyBroadCast() method which floats around even after the broadcast, allowing data to be collected from it")
            questionDao.insert(question)
            question = Question(62, "Android Asset Packaging Tool (AAPT)","This tool provides developers with the ability to deal with zip-compatible archives, which includes creating, extracting as well as viewing its contents")
            questionDao.insert(question)
            question = Question(63, "Doze","Power-saving feature that prevents your phone from carrying out certain tasks if your phone's been sitting idle for a while. It puts your phone into a deep sleep mode and only wakes it up sporadically to handle background tasks, which saves a lot of battery power. (Introduced in android 6.0)")
            questionDao.insert(question)
            question = Question(64, "Constructor","Each class of object has a method called this and that is executed automatically when an object or that class is created. This is responsible for doing everything necessary to make the object usable by the rest of the app.")
            questionDao.insert(question)
            question = Question(65, "Encapsulation","We normally do this to a field to make the object easier to use, it also makes apps easier to debug. When a field has become this, it is made accessible only via its getter and setter")
            questionDao.insert(question)
            question = Question(66, "MVC","This pattern is used to separate the applications concerns. The controller in this acts on both model and view, it controls the data flow into model object and updates the view whenever data changes. It keeps the view and model separate.")
            questionDao.insert(question)
            question = Question(67, "MVP","This pattern contains the UI business logic for the view. All invocations from the view delegate directly to the presenter which is also decoupled directly from the view and talks to it through an interface. This tends to be a very natural pattern for achieving separated presentation in web forms")
            questionDao.insert(question)
            question = Question(68, "LiveData","An observable data holder class. This is lifecycle-aware, meaning that it respects the lifecycle of other app components such as activities, fragments or services.\n" +
                    "This ensures that this only updates app component observers that are in an active lifecycle state.")
            questionDao.insert(question)
            question = Question(69, "LifeCycles","onCreate(): In this state, the activity is created\n" +
                    "onStart(): This callback method is called when the activity becomes visible to the user\n" +
                    "onRestart():\n" +
                    "onResume(): The activity is in the foreground and the user can interact with it\n" +
                    "onPause(): Activity is partially obscured by another activity. Other activity that's in the foreground is semi-transparent\n" +
                    "onStop(): The activity is completely hidden and not visible to the user\n" +
                    "onDestroy(): Activity is destroyed and removed from the memory")
            questionDao.insert(question)
            question = Question(70, "Abstract class","This type of class is a class that contains one or more abstract methods. This method is a method that is declared, but contains no implementation. And an implementation describes the interactions of elements that is written into the program")
            questionDao.insert(question)
            question = Question(71,"HashMap","This is a collection object which uses key and value pairs, where both parameters are objects declared on creation. Each key maps to a corresponding value. It is declared as HashMap<Key, Value>. This does not make any guarantees of order or sorting. When you add a key to this, there is no reason it will be returned to you at the same location or even at a constant speed")
            questionDao.insert(question)
            question = Question(72,"HashTable","An instance this has two parameters that affects its performance - initial capacity and load factor. The capacity is the number of buckets in the hash table, and the initial capacity is simply the capacity at the time the hash table is created.")
            questionDao.insert(question)
            question = Question(73,"Dagger","This is a dependency injection framework and it can be used to manage dependency to build components which can be easily enhanced. This is light weight and it generates code at compile time so it is very suitable for android.")
            questionDao.insert(question)
            question = Question(74,"?:","If the expression to the left of ?: is not null, the elvis operator returns it, otherwise it returns the expression to the right. Note that the right-hand side expression is evaluated only if the left-hand side is null.")
            questionDao.insert(question)
            question = Question(75,"?.","Safe Call \n"+"This calls the method if the property is not null or returns null if that property is null without throwing an NPE (null pointer exception).")
            questionDao.insert(question)

        }
    }
}
