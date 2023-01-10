package com.example.githubuser.data.remote

import com.example.githubuser.data.model.ItemsItem
import com.example.githubuser.data.model.ResponseDetailUser
import com.example.githubuser.data.model.ResponseUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("users")
    fun getUser() : Call<List<ItemsItem>>

    @GET("users/{username}")
    fun getDetailUser(
        @Path("username") username: String
    ) : Call<ResponseDetailUser>

}