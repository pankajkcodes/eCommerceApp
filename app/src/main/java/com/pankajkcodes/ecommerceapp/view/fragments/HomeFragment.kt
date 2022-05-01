package com.pankajkcodes.ecommerceapp.view.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pankajkcodes.ecommerceapp.databinding.FragmentHomeBinding
import com.pankajkcodes.ecommerceapp.adapters.ProductAdapter
import com.pankajkcodes.ecommerceapp.db.remote.ApiService
import com.pankajkcodes.ecommerceapp.repository.MainRepository
import com.pankajkcodes.ecommerceapp.viewModel.MainViewModel
import com.pankajkcodes.ecommerceapp.viewModel.MainViewModelFactory

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val pAdapter = ProductAdapter()
    lateinit var viewModel: MainViewModel
    private val apiService = ApiService.getInstance()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val layoutManager: RecyclerView.LayoutManager = GridLayoutManager(requireContext(), 2)
        binding.pRecycler.layoutManager = layoutManager

        binding.pRecycler.adapter = pAdapter

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(MainRepository(apiService))
        )[MainViewModel::class.java]
        viewModel.productList.observe(this, Observer {
            Log.d("TAG", "onCreate: $it")
            pAdapter.setProductList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllProducts()


        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}