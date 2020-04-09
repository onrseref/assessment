package com.onurseref.mackolik.common.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsResponse(
    @SerializedName("rss") val rss: Rss?
) : Parcelable

@Parcelize
data class Rss(
    @SerializedName("channel") val channel: Channel?,
    @SerializedName("_version") val _version: Double?
) : Parcelable

@Parcelize
data class Channel(
    @SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?,
    @SerializedName("language") val language: String?,
    @SerializedName("pubDate") val pubDate: String?,
    @SerializedName("link") val link: String?,
    @SerializedName("category") val category: List<String>?,
    @SerializedName("item") val item: List<Item>?
) : Parcelable

@Parcelize
data class Item(
    @SerializedName("guid") val guid: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("pubDate") val pubDate: String?,
    @SerializedName("enclosure") val enclosure: Enclosure?,
    @SerializedName("description") val description: String?,
    @SerializedName("link") val link: String?,
    @SerializedName("category") val category: String?
) : Parcelable

@Parcelize
data class Enclosure(
    @SerializedName("_length") val _length: Int,
    @SerializedName("_url") val _url: String,
    @SerializedName("_type") val _type: String
) : Parcelable





