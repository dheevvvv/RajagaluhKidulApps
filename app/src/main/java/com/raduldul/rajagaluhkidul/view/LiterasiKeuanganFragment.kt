package com.raduldul.rajagaluhkidul.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.FragmentLiterasiKeuanganBinding


class LiterasiKeuanganFragment : Fragment() {

    private lateinit var binding: FragmentLiterasiKeuanganBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLiterasiKeuanganBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}