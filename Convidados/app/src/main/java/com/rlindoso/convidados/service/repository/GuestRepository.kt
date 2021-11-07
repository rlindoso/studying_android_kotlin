package com.rlindoso.convidados.service.repository

import android.content.Context
import com.rlindoso.convidados.service.model.GuestModel

class GuestRepository (context: Context) {

    private var mDataBase = GuestDataBase.getDatabase(context).guestDAO()

    // CRUD - Create, Read, Update, Delete

    fun getAll(): List<GuestModel> {
        return mDataBase.getInvited()
    }

    fun getPresent(): List<GuestModel> {
        return mDataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel> {
        return mDataBase.getAbsent()
    }

    fun get(id: Int): GuestModel? {
        return mDataBase.get(id)
    }

    fun save(guest: GuestModel): Boolean {
        return mDataBase.save(guest) > 0
    }

    fun update(guest: GuestModel): Boolean {
        return mDataBase.update(guest) > 0
    }

    fun delete(guest: GuestModel): Boolean {
        return mDataBase.delete(guest) > 0
    }
}