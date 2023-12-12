package com.example.lokalassignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lokalassignment.databinding.ProductItemLayoutBinding
import com.example.lokalassignment.dataclasses.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var productList = ArrayList<Product>()

    private var onProductClickListener: ((Product) -> Unit)? = null

    fun setDataSet(productList : ArrayList<Product>) {
        this.productList = productList
        notifyDataSetChanged()
    }

    fun setOnProductClickListener(onProductClickListener: ((Product) -> Unit)?) {
        this.onProductClickListener= onProductClickListener
    }

    inner class ProductViewHolder(var binding: ProductItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product) {
            binding.product = product
            binding.root.setOnClickListener {
                onProductClickListener?.invoke(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder{
        return ProductViewHolder(ProductItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int  = productList.size

}