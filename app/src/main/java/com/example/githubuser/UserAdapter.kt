package com.example.githubuser

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.githubuser.data.model.ItemsItem
import com.example.githubuser.databinding.ItemViewBinding
import com.example.githubuser.detail.DetailActivity

class UserAdapter(private val listUser : List<ItemsItem>) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    class ViewHolder(var binding : ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvUsername.text = listUser[position].login
        Glide.with(holder.itemView.context)
            .load(listUser[position].avatarUrl)
            .into(holder.binding.imgUser)

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            context.startActivity(Intent(context, DetailActivity::class.java)
                .putExtra(DetailActivity.USERNAME, listUser[position].login))
        }
    }

    override fun getItemCount() = listUser.size

}