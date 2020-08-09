package com.cybernerd.finalproject.network

import com.cybernerd.finalproject.model.ClassroomResponse
import com.cybernerd.finalproject.model.LoginResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.*


const val BASE_URL = "https://cypherx404.herokuapp.com/"

interface CypherXAPI {


    companion object{
        operator fun invoke() : CypherXAPI{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CypherXAPI::class.java)
        }

    }


    @FormUrlEncoded
    @POST("user/login/")
    fun login(
        @Field("email")email: String,
        @Field("password")password: String
    ): Call<LoginResponse>


    @GET("classroom/manage/")
    fun getClassroom(
        @Header("Authorization") token : String): Call<ClassroomResponse>


}