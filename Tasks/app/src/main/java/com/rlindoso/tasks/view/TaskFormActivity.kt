package com.rlindoso.tasks.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.rlindoso.tasks.R
import com.rlindoso.tasks.databinding.ActivityTaskFormBinding
import com.rlindoso.tasks.viewmodel.RegisterViewModel

class TaskFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: RegisterViewModel
    private lateinit var binding: ActivityTaskFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        // Inicializa eventos
        listeners()
        observe()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.button_save) {

            //val name = binding.edit_name.text.toString()
            //val email = edit_email.text.toString()
            //val password = edit_password.text.toString()

            //mViewModel.create(name, email, password)
        }
    }

    private fun observe() {
    }

    private fun listeners() {
        binding.buttonSave.setOnClickListener(this)
    }

}
