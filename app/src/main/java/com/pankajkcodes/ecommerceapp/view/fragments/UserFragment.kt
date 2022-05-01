package com.pankajkcodes.ecommerceapp.view.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.pankajkcodes.ecommerceapp.R
import com.pankajkcodes.ecommerceapp.databinding.FragmentHomeBinding
import com.pankajkcodes.ecommerceapp.databinding.UserFragmentBinding

class UserFragment : Fragment() {
    private var _binding: UserFragmentBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = UserFragmentBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }


}