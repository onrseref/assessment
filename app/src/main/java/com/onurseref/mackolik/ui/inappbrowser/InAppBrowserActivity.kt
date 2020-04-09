package com.onurseref.mackolik.ui.inappbrowser

import android.annotation.SuppressLint
import android.webkit.GeolocationPermissions
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import com.onurseref.mackolik.R
import com.onurseref.mackolik.base.ui.BaseActivity
import com.onurseref.mackolik.databinding.ActivityInappBrowserBinding
import kotlinx.android.synthetic.main.activity_inapp_browser.*

class InAppBrowserActivity : BaseActivity() {
    private var url: String? = null


    override fun bindScreen() {
        DataBindingUtil.setContentView<ActivityInappBrowserBinding>(
            this,
            R.layout.activity_inapp_browser
        ).apply {
            this.lifecycleOwner = this@InAppBrowserActivity
        }

        url = intent.extras?.getString("URL")

        setWebView()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setWebView() {
        webView.settings.domStorageEnabled = true
        webView.settings.javaScriptEnabled = true
        webView.settings.useWideViewPort = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.builtInZoomControls = true
        webView.webChromeClient = object : WebChromeClient() {
            override fun onGeolocationPermissionsShowPrompt(
                origin: String,
                callback: GeolocationPermissions.Callback
            ) {
                callback.invoke(origin, true, false)
            }

            override fun onProgressChanged(view: WebView, progress: Int) {

            }
        }
        webView.loadUrl(url)
    }
}
