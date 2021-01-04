package com.example.projectandroidadmin.model

import com.google.gson.annotations.SerializedName

data class getdatasampahid(

    @field:SerializedName("data")
    val data: DataItemsampahid,

    @field:SerializedName("status")
    val status: String? = null
)

data class DataItemsampahid(

    @field:SerializedName("id_sampah")
    val idSampah: String? = null,

    @field:SerializedName("nama")
    val nama: String? = null,

    @field:SerializedName("updated_at")
    val updatedAt: String? = null,

    @field:SerializedName("berat")
    val berat: String? = null,

    @field:SerializedName("contact")
    val contact: String? = null,

    @field:SerializedName("jenis")
    val jenis: String? = null,

    @field:SerializedName("created_at")
    val createdAt: String? = null,

    @field:SerializedName("deleted_at")
    val deletedAt: Any? = null,

    @field:SerializedName("alamat")
    val alamat: String? = null
)
