package com.raduldul.rajagaluhkidul.model.wisatadanbudaya

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataTopRatedWisata(
    val id: Int,
    val namaWisata: String,
    val kategoriWisata: String,
    val imageResWisata: Int,
    val ratingWisata: Double,
    val jarakWisata: Double,

):Parcelable
