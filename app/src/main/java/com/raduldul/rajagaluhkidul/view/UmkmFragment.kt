package com.raduldul.rajagaluhkidul.view

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.raduldul.rajagaluhkidul.databinding.FragmentUmkmBinding


class UmkmFragment : Fragment() {
    private lateinit var binding: FragmentUmkmBinding
    private val jumlahUmkm = 20
    private var currentUmkm = 0
    private val jumlahProduk = 60
    private var currentProduk = 0
    private val jumlahJenisUsaha = 2
    private var currentJenisUsaha = 0
    @Suppress("UNREACHABLE_CODE")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUmkmBinding.inflate(layoutInflater, container, false)
        return binding.root

        startCountUpUmkm()
        startCountUpProduk()
        startCountUpJenisUsaha()

    }

    private fun startCountUpUmkm() {
        object : CountDownTimer(((jumlahUmkm + 1) * 1000).toLong(), 1000) {
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
        object : CountDownTimer(((jumlahProduk + 1) * 1000).toLong(), 1000) {
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