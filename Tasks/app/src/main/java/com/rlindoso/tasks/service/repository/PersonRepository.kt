package com.rlindoso.tasks.service.repository

import com.rlindoso.tasks.service.repository.remote.PersonService
import com.rlindoso.tasks.service.repository.remote.RetrofitClient

class PersonRepository {

    val remote = RetrofitClient.createService(PersonService::class.java)

    fun login(email: String, password: String) {

        //remote.login(email, password)

    }

}