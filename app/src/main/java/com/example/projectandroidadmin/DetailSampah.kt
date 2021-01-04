package com.example.projectandroidadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.projectandroidadmin.model.deletedatasampah
import com.example.projectandroidadmin.model.getdatasampahid
import com.example.projectandroidadmin.model.putdatasampah
import com.example.projectandroidadmin.utils.connections
import kotlinx.android.synthetic.main.activity_detail_sampah.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailSampah : AppCompatActivity(),View.OnClickListener {
    private var id : String? = null
    private var nama : String? = null
    private var alamat : String? = null
    private var contact : String? = null
    private var jenis : String? = null
    private var berat : String? = null

    companion object{
        const val ExtraId = "1"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_sampah)

        getDetailAPI()
        btn_update.setOnClickListener(this)
        btn_deleteddd.setOnClickListener(this)
    }

    //Function get Detail dari product
    private fun getDetailAPI() {
        val idget = intent.getStringExtra(ExtraId).toInt()
        connections.getRetroClientInstance.getdataid(idget).enqueue(object :
            Callback<getdatasampahid> {
            override fun onFailure(call: Call<getdatasampahid>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

            override fun onResponse(call: Call<getdatasampahid>, response: Response<getdatasampahid>) {
                id = response.body()?.data?.idSampah
                nama = response.body()?.data?.nama
                alamat = response.body()?.data?.alamat
                contact = response.body()?.data?.contact
                jenis = response.body()?.data?.jenis
                berat = response.body()?.data?.berat

                tv_nama_detail.text = nama
                et_nama.hint = nama
                et_alamat.hint = alamat
                et_contact.hint = contact
                et_jenis.hint = jenis
                et_berat.hint = berat
            }
        })
    }
    //Function Delete
    fun delete(){
        val iddelete = intent.getStringExtra(ExtraId).toInt()
        connections.getRetroClientInstance.deletedata(iddelete).enqueue(object :
            Callback<deletedatasampah> {
            override fun onFailure(call: Call<deletedatasampah>, t: Throwable) {
                Log.e("Failed",t.toString())
            }

            override fun onResponse(call: Call<deletedatasampah>, response: Response<deletedatasampah>) {
                Log.e("Success",response.code().toString())
                finish()
            }
        })
    }
    //UPDATE AND DELETE
    override fun onClick(p0: View) {
        when(p0.id){
            R.id.btn_update->{
                connections.getRetroClientInstance.putdata(
                    intent.getStringExtra(ExtraId).toInt(),
                    et_nama.text.toString(),
                    et_alamat.text.toString(),
                    et_contact.text.toString(),
                    et_jenis.text.toString(),
                    et_berat.text.toString()
                ).enqueue(object : Callback<putdatasampah> {
                    override fun onFailure(call: Call<putdatasampah>, t: Throwable) {
                        Log.e("Failed",t.toString())
                    }
                    override fun onResponse(
                        call: Call<putdatasampah>,
                        response: Response<putdatasampah>
                    ) {
                        Log.e("Success",response.code().toString())
                        val toastUpdated = Toast.makeText(applicationContext,"Data Updated", Toast.LENGTH_LONG)
                        toastUpdated.show()
                        Handler().postDelayed({
                            finish()
                            val losDol = Intent(this@DetailSampah, lihatData::class.java)
                            startActivity(losDol) }, 1020*2)
                    }
                })
            }
            R.id.btn_deleteddd->{
                delete()
                val intentdelete = Intent(this@DetailSampah,lihatData::class.java)
                startActivity(intentdelete)
            }
        }
    }
}
