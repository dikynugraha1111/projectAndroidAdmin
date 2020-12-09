package com.example.projectandroidadmin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.projectandroidadmin.model.bannerList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        banner_view_pager.adapter = BannerAdapter(bannerList)
        banner_view_pager.offscreenPageLimit = 1
    }
}
