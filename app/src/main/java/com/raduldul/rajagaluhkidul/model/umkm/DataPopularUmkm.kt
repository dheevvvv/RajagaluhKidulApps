package com.raduldul.rajagaluhkidul.model.umkm

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPopularUmkm(
    val id: Int,
    val namaUmkm: String,
    val kategoriUmkm: String,
    val imageResUmkm: Int,
    val ratingUmkm: Double,
    val jarakUmkm: Double,
):Parcelable
