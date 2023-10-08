package com.example.helloword

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val email:String,
    val password:String
):Parcelable
