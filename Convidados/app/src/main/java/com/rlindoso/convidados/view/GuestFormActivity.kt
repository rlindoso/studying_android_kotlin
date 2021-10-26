package com.rlindoso.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.rlindoso.convidados.viewmodel.GuestFormViewModel
import com.rlindoso.convidados.R
import com.rlindoso.convidados.databinding.ActivityGuestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityGuestFormBinding
    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)
        mBinding = ActivityGuestFormBinding.inflate(layoutInflater)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListener()
        observe()

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.button_save) {

            val name = mBinding.editName.text.toString()
            val presence = mBinding.radioPresence.isChecked

            mViewModel.save(name, presence)
        }
    }

    private fun observe() {
        mViewModel.saveGuest.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun setListener() {
        mBinding.buttonSave.setOnClickListener(this)
    }

}