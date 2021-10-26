package com.rlindoso.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.rlindoso.convidados.viewmodel.GuestFormViewModel
import com.rlindoso.convidados.R
import com.rlindoso.convidados.databinding.ActivityGestFormBinding

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityGestFormBinding
    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)
        mBinding = ActivityGestFormBinding.inflate(layoutInflater)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListener()

    }

    private fun setListener() {
        mBinding.buttonSave.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.button_save) {

        }
    }
}