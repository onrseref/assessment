package com.onurseref.trendyol.common.extension

import android.graphics.Color
import android.os.Build
import android.text.*
import android.text.method.LinkMovementMethod
import android.text.method.ScrollingMovementMethod
import android.text.style.ClickableSpan
import android.text.style.URLSpan
import android.view.MotionEvent
import android.view.View
import android.widget.TextView

fun String.toSpanned(): Spanned {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        @Suppress("DEPRECATION")
        return Html.fromHtml(this)
    }
}

fun TextView.customAfterTextChanged(action: (Editable?) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun afterTextChanged(editable: Editable?) {
            action(editable)
        }
    })
}

fun TextView.makeScrollableInsideScrollView() {
    movementMethod = ScrollingMovementMethod()
    setOnTouchListener { v, event ->
        v.parent.requestDisallowInterceptTouchEvent(true)
        when (event.action and MotionEvent.ACTION_MASK) {
            MotionEvent.ACTION_UP -> {
                v.parent.requestDisallowInterceptTouchEvent(false)
                performClick()
            }
        }
        false
    }
}

fun TextView.handleUrlClicks(onClicked: ((String) -> Unit)? = null) {
    //create span builder and replaces current text with it
    text = SpannableStringBuilder.valueOf(text).apply {
        //search for all URL spans and replace all spans with our own clickable spans
        getSpans(0, length, URLSpan::class.java).forEach {
            //add new clickable span at the same position
            setSpan(
                object : ClickableSpan() {
                    override fun onClick(widget: View) {
                        onClicked?.invoke(it.url)
                    }
                },
                getSpanStart(it),
                getSpanEnd(it),
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE
            )
            //remove old URLSpan
            removeSpan(it)
        }
    }
    //make sure movement method is set
    movementMethod = LinkMovementMethod.getInstance()
}


fun TextView.setTags(pTagString: String) {
    try {
        val string = SpannableString(pTagString)
        var start = -1
        var i = 0
        while (i < pTagString.length) {
            if (pTagString[i] == '#') {
                start = i
            } else if (pTagString[i] == ' ' || pTagString[i] == '\n' || i == pTagString.length - 1 && start != -1) {
                if (start != -1) {
                    if (i == pTagString.length - 1) {
                        i++
                    }
                    string.setSpan(object : ClickableSpan() {
                        override fun onClick(widget: View) {
                        }

                        override fun updateDrawState(ds: TextPaint) {
                            ds.color = Color.parseColor("#007ac3")
                            ds.isUnderlineText = false
                        }

                    }, start, i, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                    start = -1
                }
            }
            i++
        }
        text = string
    } catch (e: Exception) {
    }
}




