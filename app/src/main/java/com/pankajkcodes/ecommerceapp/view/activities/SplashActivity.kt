package com.pankajkcodes.ecommerceapp.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pankajkcodes.ecommerceapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    // view binding for the activity
    private var _binding: ActivitySplashBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }


    // on destroy of view make the binding reference to null
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}