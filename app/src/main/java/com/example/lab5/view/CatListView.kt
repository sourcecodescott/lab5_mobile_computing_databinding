package com.example.lab5.view

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.lab5.model.Cat
import com.example.lab5.R

class CatListView(application: Application) : AndroidViewModel(application) {

    val context: Context = application
    private lateinit var cats: MutableList<Cat>
    var isListCompleted = MutableLiveData<Boolean>()
    var cuteCount = MutableLiveData<Int>()
    var notCuteCount = MutableLiveData<Int>()

    /*TODO define var for imageUrl and name of type MutableLiveData */


    init {
        setupList()
    }

    fun readJsonFile() {
        val text = context.resources.openRawResource(R.raw.cat)
            .bufferedReader()
            .use { it.readText() }

        /*TODO Parse JSON data using Gson and add it to the "cats" list*/

    }

    fun advanceToNextSubject() {
        if (cats.size > 0) {
            cats.removeAt(0).let { cat ->
                /*TODO Set the value of imageUrl and name*/
            }
        } else {
            isListCompleted.value = true
        }
    }

    fun setupList() {
        isListCompleted.value = false // these are probably the default initial values (unnecessary)
        cuteCount.value = 0
        notCuteCount.value = 0
        readJsonFile()
        advanceToNextSubject()
    }

    fun cuteClicked() {
        cuteCount.value = (cuteCount.value)?.plus(1)
        advanceToNextSubject()
    }

    /*TODO Implement a fun  notCuteClicked() this will be similar to cuteClicked() */

}
