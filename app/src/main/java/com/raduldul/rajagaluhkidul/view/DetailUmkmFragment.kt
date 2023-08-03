package com.raduldul.rajagaluhkidul.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.FragmentDetailUmkmBinding
import com.raduldul.rajagaluhkidul.model.umkm.DataPopularUmkm
import com.raduldul.rajagaluhkidul.model.umkm.DataUmkm


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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataUmkm = requireArguments().getParcelable<DataUmkm>("listData")
        dataUmkm.let {
            binding.ivImgUmkm.setImageResource(it!!.imageResUmkm)
            binding.tvNamaUmkm.text = it.namaUmkm
            binding.rate.text = it.ratingUmkm.toString()
            binding.tvLokasidetail.text = it.alamat
            binding.tvSpesialisasi.text = it.spesialisasiUmkm
            binding.tvNamaProduk.text = it.namaProduk
            binding.tvNamaOwner.text = it.namaPemilik
            binding.tvHargaProduk.text = it.harga.toString()
        }

    }


}