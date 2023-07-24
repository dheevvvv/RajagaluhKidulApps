package com.raduldul.rajagaluhkidul.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.FragmentAccountBinding
import com.raduldul.rajagaluhkidul.datastore_preferences.UserManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class AccountFragment : Fragment() {
    private lateinit var binding: FragmentAccountBinding
    private lateinit var userManager: UserManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userManager = UserManager.getInstance(requireContext())

        binding.clLogout.setOnClickListener {
            GlobalScope.async {
                userManager.clearData()
            }
            findNavController().navigate(R.id.action_accountFragment_to_loginFragment)
            Toast.makeText(requireContext(), "Logout Berhasil, Anda telah Logout", Toast.LENGTH_SHORT).show()
        }

    }

}