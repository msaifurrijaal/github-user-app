package com.example.githubuser.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.example.githubuser.data.model.ItemsItem
import com.example.githubuser.data.model.ResponseDetailUser
import com.example.githubuser.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailBinding
    private val detailViewModel by viewModels<DetailViewModel>()

    companion object {
        const val USERNAME = "username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(USERNAME)

        detailViewModel.userDetail.observe(this, {
            setDetailUserData(it)
        })

        detailViewModel.fin

    }

    private fun setDetailUserData(detailUser: ResponseDetailUser) {
        val detailData = detailUser
        Glide.with(applicationContext)
            .load(detailData.avatarUrl)
            .into(binding.imgUser)
        binding.tvUserName.text = detailData.name
        binding.tvProfilUsername.text = detailData.login
        binding.tvUserLocation.text = detailData.location
    }
}