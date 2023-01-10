package com.example.githubuser.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubuser.data.model.ResponseDetailUser
import com.example.githubuser.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private val _userDetail = MutableLiveData<ResponseDetailUser>()
    val userDetail: LiveData<ResponseDetailUser> = _userDetail

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "DetailViewModel"
        private const val USERNAME = DetailActivity.USERNAME
    }

    init {
        findUserDetail(USERNAME)
    }

    private fun findUserDetail(username: String) {
        _isLoading.value = true
        val client = ApiClient.getApiService().getDetailUser(username)
        client.enqueue(object : Callback<ResponseDetailUser> {
            override fun onResponse(
                call: Call<ResponseDetailUser>,
                response: Response<ResponseDetailUser>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _userDetail.value = response.body()
                } else {
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ResponseDetailUser>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

        })
    }
}