package com.raduldul.rajagaluhkidul.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.model.umkm.DataPopularUmkm
import com.raduldul.rajagaluhkidul.model.umkm.DataUmkm
import com.raduldul.rajagaluhkidul.model.wisatadanbudaya.DataTopRatedWisata

class UmkmViewModel:ViewModel() {
    private val _listUmkm = MutableLiveData<List<DataUmkm>>()
    val listUmkm: LiveData<List<DataUmkm>> get() = _listUmkm

    private val _detailUmkm = MutableLiveData<DataUmkm>()
    val detailUmkm: LiveData<DataUmkm> get() = _detailUmkm


    init {
        loadListUmkm()
    }

    private fun loadListUmkm(){
        val data = listOf(
            DataUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),

        )
        _listUmkm.postValue(data)
    }

}