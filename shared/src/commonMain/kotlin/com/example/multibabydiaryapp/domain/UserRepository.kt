package com.example.multibabydiaryapp.domain

interface UserRepository {

    suspend fun getUsers(): List<User>
//    suspend fun createUser(body: User): Boolean
//    suspend fun getUserByName()
//    suspend fun loginUser()
}