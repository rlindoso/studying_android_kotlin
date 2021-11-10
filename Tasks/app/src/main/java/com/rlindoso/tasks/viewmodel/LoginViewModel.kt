package com.rlindoso.tasks.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.rlindoso.tasks.service.HeaderModel
import com.rlindoso.tasks.service.listener.APIListener
import com.rlindoso.tasks.service.repository.PersonRepository

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    private val mPersonRepository = PersonRepository()

    /**
     * Faz login usando API
     */
    fun doLogin(email: String, password: String) {
        mPersonRepository.login(email, password, object : APIListener{
            override fun onSuccess(model: HeaderModel) {

            }

            override fun onFailure(str: String) {

            }

        })
    }

    /**
     * Verifica se usuário está logado
     */
    fun verifyLoggedUser() {
    }

}