package com.example.projectandroidadmin.model

import com.google.gson.annotations.SerializedName

data class putdatasampah(

    @field:SerializedName("data")
    val data: DataItemSampahPut,

    @field:SerializedName("messages")
    val messages: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)

data class DataItemSampahPut(
    @field:SerializedName("nama")
    val nama: String? = null,

        @field:SerializedName("berat")
    val berat: String? = null,

    @field:SerializedName("contact")
    val contact: String? = null,

    @field:SerializedName("jenis")
    val jenis: String? = null,

    @field:SerializedName("alamat")
    val alamat: String? = null
)