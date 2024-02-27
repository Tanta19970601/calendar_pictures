package com.example.alendarpictures.db.entities.enums

import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes

enum class Lauguage(
    @IdRes val id: Int,
    @StringRes val lauguage: Int,
    @StyleRes val nameLauguage: Int
) {

}