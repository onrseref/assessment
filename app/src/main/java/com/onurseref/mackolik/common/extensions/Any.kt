package com.onurseref.mackolik.common.extensions

import java.lang.Exception

inline fun Any?.isNull(): Boolean {
    return (this == null)
}

fun Any?.isNull(listener: ReturnListener): Boolean {
    if (this.isNull()) {
        listener.onTrue()
    } else {
        listener.onFalse()
    }

    return (this == null)
}

fun Any?.isNotNull(): Boolean {
    return (this != null)
}

fun Any?.isNotNull(listener: ReturnListener): Boolean {
    if (this.isNotNull()) {
        listener.onTrue()
    } else {
        listener.onFalse()
    }
    return (this != null)
}

inline fun <R> R?.notNull(f: (it: R) -> Unit) {
    if (this != null) {
        f(this)
    }
}

inline fun <R> R?.isNull(f: (it: R?) -> Unit) {
    if (this == null) {
        f(this)
    }
}

interface ReturnListener {
    fun onTrue()
    fun onFalse()
}

fun Any?.toString(): String {
    return if (this.isNull()) {
        ""
    } else {
        try {
            this!!.toString()
        } catch (e: Exception) {
            ""
        }
    }
}
