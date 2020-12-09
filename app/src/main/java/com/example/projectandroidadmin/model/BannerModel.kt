package com.example.projectandroidadmin.model

import android.media.Image
import android.widget.ImageView
import java.net.URL

data class BannerModel(
    val id: Int,
    val name: String,
    val imageUrl: String

)

val bannerList = listOf(
    BannerModel(1, "Banner 1", "https://blogpictures.99.co/sumber-josscoid.jpg"),
    BannerModel(2, "Banner 2", "https://picsum.photos/id/1039/6945/4635"),
    BannerModel(3, "Banner 3", "https://picsum.photos/id/1038/3914/5863"),
    BannerModel(4, "Banner 4", "https://picsum.photos/id/1037/5760/3840")
)