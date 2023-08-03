package com.raduldul.rajagaluhkidul.view

import android.animation.ValueAnimator
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.FragmentUmkmBinding
import com.raduldul.rajagaluhkidul.model.umkm.DataPopularUmkm
import com.raduldul.rajagaluhkidul.model.umkm.DataUmkm
import com.raduldul.rajagaluhkidul.view.adapter.HomeAdapter
import com.raduldul.rajagaluhkidul.view.adapter.UmkmAdapter
import com.raduldul.rajagaluhkidul.viewmodel.HomeViewModel
import com.raduldul.rajagaluhkidul.viewmodel.UmkmViewModel


class UmkmFragment : Fragment() {
    private lateinit var binding: FragmentUmkmBinding
    private val jumlahUmkm = 20
    private var currentUmkm = 0
    private val jumlahProduk = 20
    private var currentProduk = 0
    private val jumlahJenisUsaha = 2
    private var currentJenisUsaha = 0
    private val umkmViewModel: UmkmViewModel by activityViewModels()
    private lateinit var umkmAdapterMakanan: UmkmAdapter
    private lateinit var umkmAdapterKerajinan: UmkmAdapter

    @Suppress("UNREACHABLE_CODE")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUmkmBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val umkmCount = binding.countJumlahUmkm
        val produkCount = binding.countJumlahProduk
        val jenisUsahaCount = binding.countJumlahJenisusaha
        startCountUpAnimation(umkmCount, jumlahUmkm)
        startCountUpAnimation(produkCount, jumlahProduk)
        startCountUpAnimation(jenisUsahaCount, jumlahJenisUsaha)
//        startCountUpUmkm()
//        startCountUpProduk()
//        startCountUpJenisUsaha()

        umkmAdapterMakanan = UmkmAdapter{
            navigateToDetailDestination(it)
        }
        umkmAdapterKerajinan = UmkmAdapter{
            navigateToDetailDestination(it)
        }
        setupRecyclerView()
        observeRecyclerView()



    }

    private fun setupRecyclerView(){
        binding.rvUmkmMakanan.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvUmkmMakanan.adapter = umkmAdapterMakanan
        binding.rvUmkmKerajinan.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvUmkmKerajinan.adapter = umkmAdapterKerajinan
    }

    private fun observeRecyclerView() {
        umkmViewModel.listUmkmMakanan.observe(viewLifecycleOwner) {
            umkmAdapterMakanan.setData(it)
        }
        umkmViewModel.listUmkmkerajinan.observe(viewLifecycleOwner) {
            umkmAdapterKerajinan.setData(it)
        }
    }

    private fun navigateToDetailDestination(listData: DataUmkm) {
        val bundle = bundleOf("listData" to listData)
        view?.findNavController()?.navigate(R.id.detailUmkmFragment, bundle)
    }

    private fun startCountUpAnimation(textView: TextView, targetValue: Int) {
        val valueAnimator = ValueAnimator.ofInt(0, targetValue)
        valueAnimator.duration = 3000 // Adjust this value to control the animation speed (milliseconds)

        valueAnimator.addUpdateListener {
            val animatedValue = it.animatedValue as Int
            textView.text = animatedValue.toString()
        }

        valueAnimator.start()
    }
    private fun startCountUpUmkm() {
        object : CountDownTimer(((jumlahUmkm + 1) * 100).toLong(), 100) {
            override fun onTick(millisUntilFinished: Long) {
                currentUmkm++
                val textViewCount = binding.countJumlahUmkm
                updateCountTextView(textViewCount, currentUmkm)
            }

            override fun onFinish() {
                // Count-up finished for field 1
            }
        }.start()
    }

    private fun startCountUpProduk() {
        object : CountDownTimer(((jumlahProduk + 1) * 50).toLong(), 50) {
            override fun onTick(millisUntilFinished: Long) {
                currentProduk++
                val countTextView2 = binding.countJumlahProduk
                updateCountTextView(countTextView2, currentProduk)
            }

            override fun onFinish() {
                // Count-up finished for field 2
            }
        }.start()
    }

    private fun startCountUpJenisUsaha() {
        object : CountDownTimer(((jumlahJenisUsaha + 1) * 1000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                currentJenisUsaha++
                val countTextView3 = binding.countJumlahJenisusaha
                updateCountTextView(countTextView3, currentJenisUsaha)
            }

            override fun onFinish() {
                // Count-up finished for field 3
            }
        }.start()
    }

    private fun updateCountTextView(textView: TextView, count: Int) {
        textView.text = count.toString()
    }
}