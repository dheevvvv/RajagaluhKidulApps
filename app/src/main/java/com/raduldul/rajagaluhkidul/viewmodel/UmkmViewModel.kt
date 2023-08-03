package com.raduldul.rajagaluhkidul.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.model.umkm.DataPopularUmkm
import com.raduldul.rajagaluhkidul.model.umkm.DataUmkm
import com.raduldul.rajagaluhkidul.model.wisatadanbudaya.DataTopRatedWisata

class UmkmViewModel:ViewModel() {
    private val _listUmkmMakanan = MutableLiveData<List<DataUmkm>>()
    val listUmkmMakanan: LiveData<List<DataUmkm>> get() = _listUmkmMakanan

    private val _listUmkmKerajinan = MutableLiveData<List<DataUmkm>>()
    val listUmkmkerajinan: LiveData<List<DataUmkm>> get() = _listUmkmKerajinan

    private val _detailUmkm = MutableLiveData<DataUmkm>()
    val detailUmkm: LiveData<DataUmkm> get() = _detailUmkm


    init {
        loadListUmkm()
    }

    private fun loadListUmkm(){
        val data = listOf(
            DataUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(2, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(3, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(4, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(5, "Kipas", "Kerajinan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(6, "Kipas", "Kerajinan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(7, "Bambu", "Kerajinan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(8, "Anyaman", "Kerajinan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),

        )
        _listUmkmMakanan.postValue(data.filter { it.kategoriUmkm == "Makanan" })
        _listUmkmKerajinan.postValue(data.filter { it.kategoriUmkm == "Kerajinan" })
    }

}