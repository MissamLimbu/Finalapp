package com.example.finalapp

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

// Retrofit API interface
interface ApiService {
    @POST("footscray/auth")
    suspend fun login(@Body credentials: LoginRequest): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getDashboardData(@Path("keypass") keypass: String): Response<DashboardResponse>
}
