package com.example.testapp.presentation.fragment

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testapp.R
import com.example.testapp.databinding.FragmentBasketBinding
import com.example.testapp.databinding.FragmentMenuBinding
import com.example.testapp.di.App
import com.example.testapp.di.ViewModelFactory
import com.example.testapp.presentation.viewModel.BasketViewModel
import com.example.testapp.presentation.viewModel.MenuViewModel
import javax.inject.Inject

class BasketFragment : Fragment() {

    companion object {
        fun newInstance() = BasketFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private lateinit var binding: FragmentBasketBinding
    private val viewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[BasketViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasketBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        (requireActivity().applicationContext as App).component.inject(this)
        super.onAttach(context)
    }



}