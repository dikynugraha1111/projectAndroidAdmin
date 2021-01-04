package com.example.projectandroidadmin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectandroidadmin.adapter.blogAdapter
import com.example.projectandroidadmin.model.DataItem
import com.example.projectandroidadmin.model.DataItemsampah
import com.example.projectandroidadmin.model.arsipsekolah
import com.example.projectandroidadmin.model.getdatasampah
import com.example.projectandroidadmin.utils.connections
import com.example.projectandroidadmin.services.getDataAPI
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_lihat_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class lihatData : AppCompatActivity() {

    private var list = ArrayList<DataItemsampah>()
    var lm = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lihat_data)

        getDataAPI()
    }


    fun getDataAPI(){
        rv_blog.setHasFixedSize(true)
        rv_blog.layoutManager = lm
//        val retro = connections().getRetroClientInstance().create(getDataAPI::class.java)

//        retro.getdata().enqueue(object : Callback<arsipsekolah> {
//            override fun onFailure(call: Call<arsipsekolah>, t: Throwable) {
//                Log.e("Failed",t.message.toString())
//            }
//
//            override fun onResponse(call: Call<arsipsekolah>, response: Response<arsipsekolah>) {
//                val data = response.body()?.status
//                Log.e("wow",data)
//                val data2 = response.body()?.data
//                val data3 = response.body()?.data.toString()
//                var gson = GsonBuilder().create()
//                var result = gson.fromJson(data3,Array<DataItem>::class.java).toList()
//
//                for (c in data2!!){
//                    Log.e("diky",c?.nama!!)
//                }
//                blogAdapter.setBlog(result)
//
//            }
//
//        })

        connections.getRetroClientInstance.getdata().enqueue(object : Callback<getdatasampah>{
            override fun onFailure(call: Call<getdatasampah>, t: Throwable) {
                Log.e("Failed", t.message.toString())
            }

            override fun onResponse(call: Call<getdatasampah>, response: Response<getdatasampah>) {
                val listData = response.body()?.data
                listData?.let { list.addAll(it) }
                val adapter = blogAdapter(list)
                rv_blog.adapter = adapter

                adapter.setOnItemClickCallback(object : blogAdapter.OnItemClickCallback{
                    override fun onItemClicked(data: DataItemsampah) {
                        val id =data.idSampah
                        Log.e("Success",id)
                        val move = Intent(this@lihatData ,DetailSampah::class.java)

                        move.putExtra(DetailSampah.ExtraId, id)
                        startActivity(move)
                    }

                })
            }

        })
    }
}
