package com.example.multibabydiaryapp.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("id") val id: Long,
    @SerialName("name") val name: String,
    @SerialName("email") val email: String? = null
)
//@file:Suppress(
//    "ArrayInDataClass",
//    "EnumEntryName",
//    "RemoveRedundantQualifierName",
//    "UnusedImport"
//)
//
//package com.example.multibabydiaryapp.domain
//
//
//import kotlinx.serialization.Serializable
//import kotlinx.serialization.SerialName
//import kotlinx.serialization.Contextual
//
///**
// *
// *
// * @param id ID
// * @param userName ユーザー名
// * @param firstName 苗字
// * @param lastName 名前
// * @param email Eメール
// * @param password パスワード
// * @param phone 携帯
// * @param userStatus ユーザーステータス
// */
//@Serializable
//
//data class User (
//
//    /* ID */
//    @SerialName(value = "id")
//    val id: kotlin.Long? = null,
//
//    /* ユーザー名 */
//    @SerialName(value = "user_name")
//    val userName: kotlin.String? = null,
//
//    /* 苗字 */
//    @SerialName(value = "first_name")
//    val firstName: kotlin.String? = null,
//
//    /* 名前 */
//    @SerialName(value = "last_name")
//    val lastName: kotlin.String? = null,
//
//    /* Eメール */
//    @SerialName(value = "email")
//    val email: kotlin.String? = null,
//
//    /* パスワード */
//    @SerialName(value = "password")
//    val password: kotlin.String? = null,
//
//    /* 携帯 */
//    @SerialName(value = "phone")
//    val phone: kotlin.String? = null,
//
//    /* ユーザーステータス */
//    @SerialName(value = "user_status")
//    val userStatus: kotlin.Int? = null
//
//)
//
