package com.example.multibabydiaryapp.domain

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.HttpStatusCode

class UserRepositoryImpl(private val userApi: UserApi) : UserRepository {
    override suspend fun getUsers(): List<User> {
        val response = userApi.getUsers()
        return if (response.status == HttpStatusCode.OK) {
            response.body() // kotlinx-serializationで自動変換
        } else {
            emptyList()
        }
    }
}

//
//class UserRepositoryImpl(private val client: HttpClient): UserRepository {
//
//    override suspend fun createUser(user: User): Boolean {
//        try {
//            userApi.createUser(user).let {
//                if (it.isSuccessful) {
//                    val body = it.body()
//                    Log.i("createUser", "success. ret=$it")
//                    Log.i("createUser", "success. body=$body")
//                    return true
//                } else {
//                    return false
//                }
//            }
//        } catch (e: IllegalArgumentException) {
//            Log.e("", e.stackTraceToString())
//        }
//        return false
//    }
//
//    override suspend fun getUserByName() {
//        try {
//            userApi.getUserByName(username = "username").let {
//                if (it.isSuccessful) {
//                    val body = it.body()
//                    Log.i("getUserByName", "success. ret=$it")
//                    Log.i("getUserByName", "success. body=$body")
//                } else {
//
//                }
//            }
//        } catch (e: Exception) {
//            Log.e("getUserByName", "failure. ${e.stackTraceToString()}")
//        }
//    }
//
//    override suspend fun loginUser() {
//        try {
//            val ret = userApi.loginUser(username = "1", password = "1")
//            val body = ret.body()
//            Log.i("loginUser", "success. body=$body")
//        } catch (e: Exception) {
//            Log.e("loginUser", "failure. ${e.stackTraceToString()}")
//        }
//    }
//}
