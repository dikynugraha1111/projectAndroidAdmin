package com.example.projectandroidadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.projectandroidadmin.model.postdatasampah
import com.example.projectandroidadmin.utils.connections
import kotlinx.android.synthetic.main.activity_buat_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BuatData : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buat_data)

        btn_kirimdata.setOnClickListener(this)
    }

    private fun createPost(nama : String, alamat : String, contact: String, jenis: String, berat: String) {
        connections.getRetroClientInstance.postdata(
            nama,
            alamat,
            contact,
            jenis,
            berat
        ).enqueue(object : Callback<postdatasampah> {
            override fun onFailure(call: Call<postdatasampah>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

            override fun onResponse(call: Call<postdatasampah>, response: Response<postdatasampah>) {
                val hasil = "Response code: + ${response.code()} "
                tv_hasilkirim.text = hasil
                val toastCreated = Toast.makeText(applicationContext,"Data Terikirim", Toast.LENGTH_LONG)
                toastCreated.show()
            }

        })


    }

    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_kirimdata->{
                createPost(
                    et_namapost.text.toString(),
                    et_alamatpost.text.toString(),
                    et_contactpost.text.toString(),
                    et_jenispost.text.toString(),
                    et_beratpost.text.toString()
                )
                Handler().postDelayed({
                    finish()
                    val losDol = Intent(this, lihatData::class.java)
                    startActivity(losDol) }, 1020*2)
            }
        }
    }
}
