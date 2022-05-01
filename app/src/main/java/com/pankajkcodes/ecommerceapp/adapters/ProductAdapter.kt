package com.pankajkcodes.ecommerceapp.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pankajkcodes.ecommerceapp.databinding.ProductItemLayoutBinding
import com.pankajkcodes.ecommerceapp.model.ProductItems
import com.pankajkcodes.ecommerceapp.view.activities.ProductDetailsActivity

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    var pList = mutableListOf<ProductItems>()
    @SuppressLint("NotifyDataSetChanged")
    fun setProductList(movies: List<ProductItems>) {
        this.pList = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding =
            ProductItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val itemList = pList[position]
        holder.binding.productName.text = itemList.title
        holder.binding.productPrice.text = itemList.price.toString()
        holder.binding.root.setOnClickListener {
            val intent = Intent(it.context,ProductDetailsActivity::class.java)
            intent.putExtra("title",itemList.title)
            intent.putExtra("description",itemList.description)
            intent.putExtra("category",itemList.category)
            intent.putExtra("price",itemList.price.toString())
            intent.putExtra("image",itemList.image)

            it.context.startActivity(intent)
        }
        Glide.with(holder.itemView.context).
        load(itemList.image).into(holder.binding.imageView)

    }

    override fun getItemCount(): Int {
        return pList.size
    }

    class ProductViewHolder(val binding: ProductItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

}