package com.raduldul.rajagaluhkidul.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.model.umkm.DataPopularUmkm
import com.raduldul.rajagaluhkidul.model.umkm.DataUmkm
import com.raduldul.rajagaluhkidul.model.wisatadanbudaya.DataTopRatedWisata


class HomeViewModel:ViewModel() {
    private val _listPopularUmkm = MutableLiveData<List<DataPopularUmkm>>()
    val listPopularUmkm:LiveData<List<DataPopularUmkm>> get() = _listPopularUmkm

    private val _listTopRatedWisata = MutableLiveData<List<DataTopRatedWisata>>()
    val llistTopRatedWisata:LiveData<List<DataTopRatedWisata>> get() = _listTopRatedWisata


    init {
        loadListPopularUmkm()
        loadListTopRatedWisata()
    }

    private fun loadListPopularUmkm(){
        val data = listOf(
            DataPopularUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataPopularUmkm(2, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataPopularUmkm(3, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
            DataPopularUmkm(4, "Tsamie", "Makanan", R.drawable.tsamie, R.drawable.tsamie , 8.6 , 0.5, "Ramen", "Curry Ramen", "085224455766", "Rajagaluh Kidul, Majalengka, Jawa Barat", 25000, "Dendi, Diki, Agung"),
        )
        _listPopularUmkm.postValue(data)
    }

    private fun loadListTopRatedWisata(){
        val data = listOf(
            DataTopRatedWisata(1, "Aryakibans", "Adventure", R.drawable.aryakibans, 8.6, 1.0,),
            DataTopRatedWisata(2, "Batu Jangkung", "History", R.drawable.batujangkung, 8.1, 0.5,),
            DataTopRatedWisata(3, "Aryakibans", "Adventure", R.drawable.aryakibans, 8.6, 0.5,),
            DataTopRatedWisata(4, "Aryakibans", "Adventure", R.drawable.aryakibans, 8.6, 0.5,)

        )
        _listTopRatedWisata.postValue(data)
    }
}