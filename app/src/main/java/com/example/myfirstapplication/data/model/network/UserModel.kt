package com.example.myfirstapplication.data.model.network

import androidx.annotation.OptIn
import androidx.media3.common.util.Log
import androidx.media3.common.util.UnstableApi
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myfirstapplication.data.model.network.ApiService
import retrofit2.Response

data class LoginResponse(
    val login: String,
    val user: List<User>
)

data class LoginRequest(
    val username: String,
    val password: String
)

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val password: String
)