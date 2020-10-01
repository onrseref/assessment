package com.onurseref.marvel.data

import com.onurseref.marvel.common.utils.Utils
import java.util.*
import javax.inject.Inject

@Suppress("PrivatePropertyName")
class RemoteDataSource @Inject constructor(private val service: Service) {

    private val MARVEL_PRIVATE_KEY = "240979c9f1b57ab858d8593183dbdfb315a76a3e"
    private val MARVEL_PUBLIC_KEY = "499313e55b0ec814ce046087a830b645"
    private val limit = 30

    private val timestamp = Date().time
    private val hash = Utils.md5(timestamp.toString() + MARVEL_PRIVATE_KEY + MARVEL_PUBLIC_KEY)

    fun getCharacters(offset: Int?) =
        service.getCharacters(timestamp.toString(), limit, offset, MARVEL_PUBLIC_KEY, hash)
}