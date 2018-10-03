package com.example.user.nastya_danchenko_shop

import com.chibatching.kotpref.KotprefModel

// не класс, объекта достаточно, т.к. настройки одни на весь проект
object Preferences : KotprefModel() {
    var currentCategoriesUrl by nullableStringPref(default = null)
//    var totalPrice by floatPref()
//    var totalPrice by intPref()
//    var totalPrice by stringSetPref()
    var isLoogedIn by booleanPref(default = false) //можно использовать для экрана входа
}



