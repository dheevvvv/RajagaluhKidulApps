package com.raduldul.rajagaluhkidul.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.FragmentDetailWisataBudayaBinding


class DetailWisataBudayaFragment : Fragment() {
   private lateinit var binding: FragmentDetailWisataBudayaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailWisataBudayaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}