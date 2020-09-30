package com.onurseref.marvel.common.extension

import com.onurseref.marvel.common.extension.isNull
import java.util.*

/**Examples**/
/**
 * var time = 1571605729789L
 *
 * time.toDateTime() -> return as Date
 *
 * if it is null, return null
 */
fun Long?.toDateTime(): Date? = if(this.isNull()) null else Date(this!!)