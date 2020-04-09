package com.onurseref.mackolik.common.extensions

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

fun String.formatDate(): String {

    return try {
        var dateFormat: DateFormat =
            SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.getDefault())
        val date = dateFormat.parse(this)
        dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault())
        dateFormat.format(date)
    } catch (
        e: Exception
    ) {
        this
    }
}