package com.rlindoso.convidados.view.viewholder

import android.app.AlertDialog
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

        textName.setOnLongClickListener{

            AlertDialog.Builder(itemView.context)
                .setTitle(R.string.remocao_convidado)
                .setMessage(R.string.deseja_remover)
                .setPositiveButton(R.string.remover) {_, _ ->
                    listener.onDelete(guest)
                }
                .setNeutralButton(R.string.cancelar, null)
                .show()

            true
        }
    }

}