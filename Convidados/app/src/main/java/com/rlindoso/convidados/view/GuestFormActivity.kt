package com.rlindoso.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.rlindoso.convidados.viewmodel.GuestFormViewModel
import com.rlindoso.convidados.R
import com.rlindoso.convidados.databinding.ActivityGuestFormBinding
import com.rlindoso.convidados.service.constants.GuestConstants

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityGuestFormBinding
    private lateinit var mViewModel: GuestFormViewModel

    private var mGuestId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        mBinding.radioPresence.isChecked = true

        setListener()
        observe()
        loadData()

    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            mGuestId = bundle.getInt(GuestConstants.GUESTID)
            mViewModel.load(mGuestId)
        }
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.button_save) {

            val name = mBinding.editName.text.toString()
            val presence = mBinding.radioPresence.isChecked

            mViewModel.save(mGuestId, name, presence)
        }
    }

    private fun observe() {
        mViewModel.saveGuest.observe(this, {
            if (it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
            finish()
        })

        mViewModel.guest.observe(this, {
            mBinding.editName.setText(it.name)
            if (it.presence) {
                mBinding.radioPresence.isChecked = true
            } else {
                mBinding.radioAbsent.isChecked = true
            }
        })
    }

    private fun setListener() {
        mBinding.buttonSave.setOnClickListener(this)
    }

}