package com.onurseref.trendyol.common.extension

import android.webkit.GeolocationPermissions
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.BindingAdapter


/**
 * Created by Onur Şeref on 21.09.2020.
 * Loodos
 * onur.seref@loodos.com
 */

@BindingAdapter("loadHtml")
fun WebView.loadHtml(
    description: String?
) {
    isVerticalScrollBarEnabled = false
    isHorizontalScrollBarEnabled = false
    isScrollContainer = false
    settings.javaScriptEnabled = true
    settings.loadWithOverviewMode = true
    settings.useWideViewPort = true
    settings.builtInZoomControls = false
    settings.defaultFontSize = 45
    webChromeClient = object : WebChromeClient() {
        override fun onGeolocationPermissionsShowPrompt(
            origin: String,
            callback: GeolocationPermissions.Callback
        ) {
            callback.invoke(origin, true, false)
        }
    }
    webViewClient = object : WebViewClient() {

    }
    webChromeClient = WebChromeClient()
    loadDataWithBaseURL(
        null,
        description,
        "text/html",
        "UTF-8",
        null
    )
}