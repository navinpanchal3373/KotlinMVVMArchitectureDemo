package com.example.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmvvmarchitecturedemo.databinding.AdapterMovieBinding
import com.example.model.Movie

class MainAdapter : RecyclerView.Adapter<MainHolderBinding>() {

    var movie = mutableListOf<Movie>()

    fun setMoveList(movie: List<Movie>) {
        this.movie = movie.toMutableList();
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolderBinding {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainHolderBinding(binding)
    }

    override fun onBindViewHolder(holder: MainHolderBinding, position: Int) {
        val movie = movie[position]
        holder.binding.tvName.text = movie.name
    }

    override fun getItemCount(): Int {
        return movie.size
    }
}

data class MainHolderBinding constructor(val binding: AdapterMovieBinding) :
    RecyclerView.ViewHolder(binding.root) {}