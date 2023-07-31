package com.raduldul.rajagaluhkidul.view.adapter

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.databinding.ItemPopularUmkmBinding
import com.raduldul.rajagaluhkidul.databinding.ItemTopRatedWisataBinding
import com.raduldul.rajagaluhkidul.model.umkm.DataPopularUmkm
import com.raduldul.rajagaluhkidul.model.wisatadanbudaya.DataTopRatedWisata

class TopRatedWisataAdapter (private val onItemClick: (DataTopRatedWisata) -> Unit): RecyclerView.Adapter<TopRatedWisataAdapter.ViewHolder>() {
    private val listData: MutableList<DataTopRatedWisata> = mutableListOf()

    class ViewHolder(val binding: ItemTopRatedWisataBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemTopRatedWisataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listData[position]
        holder.binding.tvTitleItemTopRatedWisata.text = list.namaWisata
        holder.binding.tvKategoriItemPopularUmkm.text = list.kategoriWisata
        Glide.with(holder.itemView).load(list.imageResWisata)
            .into(holder.binding.ivPopularWisata)
        holder.binding.onClickDetail.setOnClickListener{
            onItemClick(list)
            navigateToDetailFragment(it, list)
        }
        holder.binding.rate.text = list.ratingWisata.toString()
        holder.binding.jarak.text = list.jarakWisata.toString() + "km"

    }

    fun setData(listData: List<DataTopRatedWisata>) {
        this.listData.clear()
        this.listData.addAll(listData)
        notifyDataSetChanged()
    }

    private fun navigateToDetailFragment(view: View, listData: DataTopRatedWisata) {
        val bundle = Bundle()
        bundle.putParcelable("listData", listData)
        view.findNavController().navigate(R.id.homeFragment, bundle)
    }
}