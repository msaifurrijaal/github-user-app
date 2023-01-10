package com.example.githubuser.data.remote

import com.example.githubuser.data.model.ItemsItem
import com.example.githubuser.data.model.ResponseUser
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUser() : Call<List<ItemsItem>>
}