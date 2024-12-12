package com.devspace.recyclerview

import androidx.annotation.DrawableRes

data class contact(
    val name: String,
    val phone: String,
    @DrawableRes val image: Int
)
