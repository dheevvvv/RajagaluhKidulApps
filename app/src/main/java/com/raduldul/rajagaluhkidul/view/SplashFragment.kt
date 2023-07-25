package com.raduldul.rajagaluhkidul.view

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.FragmentSplashBinding
import com.raduldul.rajagaluhkidul.datastore_preferences.UserManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private lateinit var binding:FragmentSplashBinding
    private lateinit var userManager: UserManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userManager = UserManager.getInstance(requireContext())

        Handler().postDelayed({
            lifecycleScope.launch {
                if (userManager.isLoggedIn().first()){
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                }else{
                    userManager.clearData()
                    findNavController().navigate(R.id.action_splashFragment_to_welcomePageFragment)
                }
            }
        },2500)
    }

}