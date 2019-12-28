package com.example.vinicecream.view.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import com.example.vinicecream.R

class IceCreamDetail : Fragment() {

    companion object {
        fun newInstance() = IceCreamDetail()
    }

    private lateinit var viewModel: IceCreamDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.ice_cream_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(IceCreamDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
