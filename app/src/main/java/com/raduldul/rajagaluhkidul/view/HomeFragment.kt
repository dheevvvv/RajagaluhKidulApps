package com.raduldul.rajagaluhkidul.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.FragmentHomeBinding
import com.raduldul.rajagaluhkidul.model.umkm.DataPopularUmkm
import com.raduldul.rajagaluhkidul.model.wisatadanbudaya.DataTopRatedWisata
import com.raduldul.rajagaluhkidul.view.adapter.HomeAdapter
import com.raduldul.rajagaluhkidul.view.adapter.TopRatedWisataAdapter
import com.raduldul.rajagaluhkidul.viewmodel.HomeViewModel
import com.raduldul.rajagaluhkidul.viewmodel.UserViewModel


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val userViewModel: UserViewModel by activityViewModels()
    private val homeViewModel: HomeViewModel by activityViewModels()
    private lateinit var homeAdapter: HomeAdapter
    private lateinit var topRatedWisataAdapter: TopRatedWisataAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item->
            when(item.itemId) {
                R.id.account -> {
                    findNavController().navigate(R.id.action_homeFragment_to_accountFragment)
                    true
                } else -> false
            }
        }

        userViewModel.getUsername()
        userViewModel.username.observe(viewLifecycleOwner){
            binding.tvHome.text = "Welcome," + "  " + it + "!"
        }

        homeAdapter = HomeAdapter{
            navigateToDetailDestination(it)
        }
        topRatedWisataAdapter = TopRatedWisataAdapter{dataWisataTop->
            navigateToDetailDestinationTopWisata(dataWisataTop)
        }

        setupRecyclerView()
        observeRecyclerView()


    }

    private fun setupRecyclerView(){
        binding.rvPopularUmkm.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvPopularUmkm.adapter = homeAdapter
        binding.rvTopRatedWisata.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvTopRatedWisata.adapter = topRatedWisataAdapter
    }

    private fun observeRecyclerView() {
        homeViewModel.listPopularUmkm.observe(viewLifecycleOwner) {
            homeAdapter.setData(it)
        }
        homeViewModel.llistTopRatedWisata.observe(viewLifecycleOwner) {
            topRatedWisataAdapter.setData(it)
        }
    }

    private fun navigateToDetailDestination(listData: DataPopularUmkm) {
        val bundle = bundleOf("listData" to listData)
        view?.findNavController()?.navigate(R.id.homeFragment, bundle)
    }
    private fun navigateToDetailDestinationTopWisata(listData: DataTopRatedWisata) {
        val bundle = bundleOf("listData" to listData)
        view?.findNavController()?.navigate(R.id.homeFragment, bundle)
    }


}