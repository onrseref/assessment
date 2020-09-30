package com.onurseref.marvel.common.extension

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.request.RequestOptions
import com.squareup.picasso.Callback
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.NetworkPolicy
import com.squareup.picasso.Picasso

/**Examples**/
/**
 * imgView.loadImage(context, "...url...", R.drawable.placeholder)
 * imgView.loadImage(context, "...url...", null)
 *
 * parameters -->
 * context -> not null
 * url -> should be url
 * placeholder -> can be null
 */
fun ImageView.loadImage(
    context: Context,
    url: String,
    placeholder: Drawable?
) {
    if (placeholder != null) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .placeholder(placeholder)
            .thumbnail(0.5f)
            .centerCrop()
            .into(this)
    } else {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .thumbnail(0.5f)
            .centerCrop()
            .into(this)
    }
}

fun ImageView.loadCircleImageUri(
    context: Context,
    url: Uri,
    placeholder: Drawable?
) {
    if (placeholder != null) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .placeholder(placeholder)
            .thumbnail(0.5f)
            .fitCenter()
            .apply(RequestOptions.circleCropTransform())
            .into(this)
    } else {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .thumbnail(0.5f)
            .apply(RequestOptions.circleCropTransform())
            .into(this)
    }
}

fun ImageView.loadImageFitCenter(
    url: String,
    placeholder: Drawable?
) {

    if (placeholder != null) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .placeholder(placeholder)
            .fitCenter()
            .into(this)
    } else {
        val headerWithUrl = GlideUrl(
            url, LazyHeaders.Builder()
                .addHeader("User-Agent", "your-user-agent")
                .build()
        )
        Glide.with(context)
            .load(headerWithUrl)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .fitCenter()
            .into(this)
    }
}

fun ImageView.loadImageCenterInside(
    url: String,
    placeholder: Drawable?
) {
    if (placeholder != null) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .placeholder(placeholder)
            .centerInside()
            .into(this)
    } else {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .centerInside()
            .into(this)
    }
}

fun ImageView.loadImageCenterCrop(
    url: String,
    placeholder: Drawable?
) {
    if (placeholder != null) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .placeholder(placeholder)
            .centerCrop()
            .into(this)
    } else {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .centerCrop()
            .into(this)
    }
}


/**Examples**/
/**
 * imgView.loadImage(context,R.drawable.image, R.drawable.placeholder)
 * imgView.loadImage(context, "...url...", null)
 *
 * parameters -->
 * context -> not null
 * url -> should be url
 * placeholder -> can be null
 */
fun ImageView.loadImage(
    context: Context,
    url: Drawable,
    placeholder: Drawable?
) {
    if (placeholder != null) {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .placeholder(placeholder)
            .thumbnail(0.5f)
            .centerCrop().into(this)
    } else {
        Glide.with(context)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(false)
            .thumbnail(0.5f)
            .centerCrop()
            .into(this)
    }
}