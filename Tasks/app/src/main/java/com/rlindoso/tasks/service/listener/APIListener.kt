package com.rlindoso.tasks.service.listener

import com.rlindoso.tasks.service.HeaderModel

interface APIListener {

    fun onSuccess(model: HeaderModel)

    fun onFailure(str: String)

}