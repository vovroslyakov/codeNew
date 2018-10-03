package com.example.user.nastya_danchenko_shop

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

val di = Kodein {
    bind<RequestMaker>() with singleton { OkHttpRequestMaker() } //можно заменить на дефолтный
}
