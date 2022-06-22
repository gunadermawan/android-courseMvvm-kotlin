package com.gunder.coursemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val scoreA: MutableLiveData<Int> = MutableLiveData()
    private val scoreB: MutableLiveData<Int> = MutableLiveData()

    fun resetScore() {

    }

    fun minScoreB() {

    }

    fun addScoreB() {

    }

    fun minScoreA() {

    }

    fun addScoreA() {

    }

    fun getScoreA(): LiveData<Int> {
        if (scoreA.value == null) {
            scoreA.value = 0
        }
        return scoreA
    }

    fun getScoreB(): LiveData<Int> {
        if (scoreB.value == null) {
            scoreB.value = 0
        }
        return scoreB
    }
}