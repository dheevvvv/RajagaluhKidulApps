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
            DataUmkm(2, "Usaha Rumahan", "Makanan", R.drawable.rengginangmentahmatang, R.drawable.rengginangmentahmatang , 8.2 , 1.5, "Rengginang Mentah dan Matang", "Rengginang mentah dan matang", "083824976319", "Rajagaluh Kidul, Majalengka, Jawa Barat", 230, "Pak Iwan"),
            DataUmkm(3, "Suung Guh", "Makanan", R.drawable.suungguh, R.drawable.suungguh , 8.4 , 0.5, "Keripik Jamur", "Keripik jamur", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 15000, "Dendi"),
            DataUmkm(4, "Bibit Jamur", "Makanan", R.drawable.jamur, R.drawable.jamur , 8.8 , 0.5, "Bibit Jamur", "Bibit Jamur", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 3000, "Dendi"),
            DataUmkm(5, "Kipas Bambu", "Kerajinan", R.drawable.kipasbambu, R.drawable.kipasbambu , 9.6 , 2.5, "Kerajinan", "Kipas Bambu", "083155474555", "Rajagaluh Kidul, Majalengka, Jawa Barat", 1500, "Bu Aan"),
            DataUmkm(6, "Usaha Rumahan", "Kerajinan", R.drawable.usaharumahan, R.drawable.usaharumahan , 8.8 , 2.1, "Anyaman Sintetis", "Variasi Anyaman", "082130804198", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Bu Rita"),
            DataUmkm(7, "Bambu", "Kerajinan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataUmkm(8, "Anyaman", "Kerajinan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),

        )
        _listUmkmMakanan.postValue(data.filter { it.kategoriUmkm == "Makanan" })
        _listUmkmKerajinan.postValue(data.filter { it.kategoriUmkm == "Kerajinan" })
    }

}