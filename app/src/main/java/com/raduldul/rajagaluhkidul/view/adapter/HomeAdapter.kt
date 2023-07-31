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
import com.raduldul.rajagaluhkidul.model.umkm.DataPopularUmkm
import com.raduldul.rajagaluhkidul.model.wisatadanbudaya.DataTopRatedWisata

class HomeAdapter(private val onItemClick: (DataPopularUmkm) -> Unit): RecyclerView.Adapter<HomeAdapter.ViewHolder>() {
    private val listData: MutableList<DataPopularUmkm> = mutableListOf()

    class ViewHolder(val binding:ItemPopularUmkmBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemPopularUmkmBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = listData[position]
        holder.binding.tvTitleItemPopularUmkm.text = list.namaUmkm
        holder.binding.tvKategoriItemPopularUmkm.text = list.kategoriUmkm
        Glide.with(holder.itemView).load(list.imageResUmkm)
            .into(holder.binding.ivPopularUmkm)
        holder.binding.onClickDetail.setOnClickListener{
            onItemClick(list)
            navigateToDetailFragment(it, list)
        }
        holder.binding.rate.text = list.ratingUmkm.toString()
        holder.binding.jarak.text = list.jarakUmkm.toString() + "km"

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(listData: List<DataPopularUmkm>) {
        this.listData.clear()
        this.listData.addAll(listData)
        notifyDataSetChanged()
    }

    private fun navigateToDetailFragment(view: View, listData: DataPopularUmkm) {
        val bundle = Bundle()
        bundle.putParcelable("listData", listData)
        view.findNavController().navigate(R.id.homeFragment, bundle)
    }
}