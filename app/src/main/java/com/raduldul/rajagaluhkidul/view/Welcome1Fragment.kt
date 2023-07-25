package com.raduldul.rajagaluhkidul.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.FragmentWelcome1Binding


class Welcome1Fragment : Fragment() {
    private lateinit var binding: FragmentWelcome1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWelcome1Binding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(INTRO_STRING_OBJECT) }?.apply {
            binding.viewPagerHeader.text = getStringArray(INTRO_STRING_OBJECT)!![0]
            binding.viewPagerSubText.text = getStringArray(INTRO_STRING_OBJECT)!![1]
            change(getStringArray(INTRO_STRING_OBJECT)!![2])
        }

        binding.skipText.setOnClickListener {
            findNavController().navigate(R.id.action_welcomePageFragment_to_loginFragment)
        }
    }

    fun change(color:String){
        when(color)
        {
            "R" -> {
                binding.baseLinear.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.earth_01
                    )
                )
                binding.ivWelcome.setImageResource(R.drawable.bro)
            }
            "G" -> {
                binding.baseLinear.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.earth_01))
                binding.ivWelcome.setImageResource(R.drawable.bromarket)
            }

            "B" -> {
                binding.baseLinear.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.earth_01))
                binding.ivWelcome.setImageResource(R.drawable.wisatabudaya)
            }

            "D" -> {
                binding.baseLinear.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.earth_01))
                binding.ivWelcome.setImageResource(R.drawable.financial)
            }
        }
    }


}