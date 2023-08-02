package com.raduldul.rajagaluhkidul.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.FragmentDetailUmkmBinding


class DetailUmkmFragment : Fragment() {
    private lateinit var binding: FragmentDetailUmkmBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailUmkmBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}