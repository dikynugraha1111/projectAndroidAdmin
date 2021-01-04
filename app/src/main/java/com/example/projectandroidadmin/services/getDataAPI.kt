package com.example.projectandroidadmin.services

import com.example.projectandroidadmin.model.*
import retrofit2.Call

import retrofit2.http.*

interface getDataAPI {
    @GET("sampah")
    fun getdata() : Call<getdatasampah>

    @GET("sampahid")
    fun getdataid(@Query("id_sampah")getid : Int) : Call<getdatasampahid>

    @FormUrlEncoded
    @POST("sampah")
    fun postdata(
        @Field("nama") nama:String,
        @Field("alamat") alamat:String,
        @Field("contact") contact:String,
        @Field("jenis") jenis:String,
        @Field("berat") berat:String
    ) : Call<postdatasampah>

    @FormUrlEncoded
    @PUT("sampah")
    fun putdata(
        @Field("id_sampah") id:Int,
        @Field("nama") nama:String,
        @Field("alamat") alamat:String,
        @Field("contact") contact:String,
        @Field("jenis") jenis:String,
        @Field("berat") berat:String
    ) : Call<putdatasampah>


    @DELETE("sampah/{id_sampah}")
    fun deletedata(
        @Path("id_sampah") idnya:Int
    ) : Call<deletedatasampah>


}