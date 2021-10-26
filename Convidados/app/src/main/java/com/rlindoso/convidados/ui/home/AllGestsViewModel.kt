package com.rlindoso.convidados.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AllGestsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is All Gests Fragment"
    }
    val text: LiveData<String> = _text
}