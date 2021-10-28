package com.rlindoso.convidados.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rlindoso.convidados.R
import com.rlindoso.convidados.service.model.GuestModel
import com.rlindoso.convidados.view.listener.GuestListener

class GuestViewHolder(itemView: View, private val listener: GuestListener): RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name

        textName.setOnClickListener {
            listener.onClick(guest.id)
        }
    }

}