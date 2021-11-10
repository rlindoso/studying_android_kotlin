package com.rlindoso.tasks.service.repository

import com.rlindoso.tasks.service.HeaderModel
import com.rlindoso.tasks.service.listener.APIListener
import com.rlindoso.tasks.service.repository.remote.PersonService
import com.rlindoso.tasks.service.repository.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository {

    private val mRemote = RetrofitClient.createService(PersonService::class.java)

    fun login(email: String, password: String, listener: APIListener) {

        val call = mRemote.login(email, password)
        call.enqueue(object : Callback<HeaderModel> {
            override fun onResponse(call: Call<HeaderModel>, response: Response<HeaderModel>) {
                response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<HeaderModel>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

        })

        //remote.login(email, password)

    }

}