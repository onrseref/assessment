package com.onurseref.marvel.common.utils

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


/**
 * Created by Onur Şeref on 1.10.2020.
 * Loodos
 * onur.seref@loodos.com
 */
object Utils {
    fun md5(stringToHash: String): String {
        val MD5 = "MD5"

        try {
            val digest = MessageDigest.getInstance(MD5)
            digest.update(stringToHash.toByteArray())
            val messageDigest = digest.digest()

            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2)
                    h = "0" + h
                hexString.append(h)
            }
            return hexString.toString()

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }

        return ""
    }
}