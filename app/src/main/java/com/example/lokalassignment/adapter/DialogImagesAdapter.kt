package com.example.lokalassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lokalassignment.databinding.ProductImagefileLayoutBinding

class DialogImagesAdapter: RecyclerView.Adapter<DialogImagesAdapter.ImagesViewHolder>() {

    private var imageList = ArrayList<String>()

    fun setDataSet(imageList : ArrayList<String>) {
        this.imageList = imageList
        notifyDataSetChanged()
    }

    inner class ImagesViewHolder(var binding: ProductImagefileLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            binding.url= image
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder{
        return ImagesViewHolder(ProductImagefileLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount(): Int  = imageList.size

}