package com.raduldul.rajagaluhkidul.model.umkm

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPopularUmkm(
    val id: Int,
    val namaUmkm: String,
    val kategoriUmkm: String,
    val imageResUmkm: Int,
    val imageResProdukUmkm: Int,
    val ratingUmkm: Double,
    val jarakUmkm: Double,
    val spesialisasiUmkm: String,
    val namaProduk:String,
    val kontakTelepon:String,
    val alamat:String,
    val harga:Int,
    val namaPemilik:String
):Parcelable
