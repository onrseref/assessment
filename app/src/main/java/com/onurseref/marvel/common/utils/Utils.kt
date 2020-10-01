package com.onurseref.marvel.common.utils

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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

    abstract class PaginationListener(private val layoutManager: LinearLayoutManager) :
        RecyclerView.OnScrollListener() {

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val totalItemCount = layoutManager.itemCount
            val findLastVisibleItemPosition =
                layoutManager.findLastCompletelyVisibleItemPosition() + 1
            if (findLastVisibleItemPosition >= totalItemCount) {
                loadMoreItems()
            }
        }

        protected abstract fun loadMoreItems()

        companion object {
            const val PAGE_START = 0
        }
    }
}