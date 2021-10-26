package com.rlindoso.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rlindoso.convidados.service.model.GuestModel
import com.rlindoso.convidados.service.repository.GuestRepository

class GuestFormViewModel: ViewModel() {

    private val mGuestRepository = GuestRepository()

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest: LiveData<Boolean> = mSaveGuest

    fun save(name: String, presence: Boolean) {
        val guest = GuestModel(name, presence)
        mGuestRepository.save(guest)
    }

}