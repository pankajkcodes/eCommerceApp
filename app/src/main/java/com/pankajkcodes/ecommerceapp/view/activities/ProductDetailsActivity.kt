package com.pankajkcodes.ecommerceapp.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.pankajkcodes.ecommerceapp.R
import com.pankajkcodes.ecommerceapp.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val title = intent.getStringExtra("title")
        val price = intent.getStringExtra("price")
        val description = intent.getStringExtra("description")
        val image = intent.getStringExtra("image")
        binding.dProductName.text = title
        binding.dProductPrice.text = price
        binding.dProductDescription.text = description

        Glide.with(this).load(image).into(binding.dProductImage)


    }
}