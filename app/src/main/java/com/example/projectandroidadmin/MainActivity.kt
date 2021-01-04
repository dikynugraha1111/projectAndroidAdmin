package com.example.projectandroidadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projectandroidadmin.model.bannerList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        banner_view_pager.adapter = BannerAdapter(bannerList)
        banner_view_pager.offscreenPageLimit = 1

        btn_lihatData.setOnClickListener(this)
        btn_tambahData.setOnClickListener(this)
    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_lihatData->{
                val intentLihatData = Intent(this@MainActivity,lihatData::class.java)
                startActivity(intentLihatData)
            }
            R.id.btn_tambahData->{
                val intentTambahData = Intent(this@MainActivity,BuatData::class.java)
                startActivity(intentTambahData)
            }
        }
    }
}
