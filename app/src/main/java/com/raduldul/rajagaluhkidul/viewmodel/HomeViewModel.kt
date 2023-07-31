package com.raduldul.rajagaluhkidul.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raduldul.rajagaluhkidul.R
import com.raduldul.rajagaluhkidul.model.umkm.DataPopularUmkm
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
            DataPopularUmkm(1, "Tsamie", "Makanan", R.drawable.tsamie, 8.6, 0.5,),
            DataPopularUmkm(2, "Jalakotek", "Makanan", R.drawable.jalakotek, 7.6, 0.1,),
            DataPopularUmkm(3, "Tsamie", "Makanan", R.drawable.tsamie, 8.6, 0.5,),
            DataPopularUmkm(4, "Tsamie", "Makanan", R.drawable.tsamie, 8.6, 0.5,),
            DataPopularUmkm(5, "Tsamie", "Makanan", R.drawable.tsamie, 8.6, 0.5,),
            DataPopularUmkm(6, "Tsamie", "Makanan", R.drawable.tsamie, 8.6, 0.5,)
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