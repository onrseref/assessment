package com.onurseref.mackolik.common.extensions

import android.content.Context
import android.util.DisplayMetrics
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.roundToInt

fun String.getDateFromMilliSeconds(): Long {
    val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    try {
        val date_ = formatter.parse(this)
        return date_.time
    } catch (e: ParseException) {
        e.printStackTrace()
    }
    return -1
}

fun Int.dpToPx(context: Context): Int {
    val displayMetrics: DisplayMetrics = context.resources.displayMetrics
    return (this * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
}