package com.rlindoso.convidados.view.listener

import com.rlindoso.convidados.service.model.GuestModel

interface GuestListener {
    fun onClick(id: Int)
    fun onDelete(guest: GuestModel)
}