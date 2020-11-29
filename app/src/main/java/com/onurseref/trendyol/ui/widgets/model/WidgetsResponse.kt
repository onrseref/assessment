package com.onurseref.trendyol.ui.widgets.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


/**
 * Created by Onur Şeref on 30.09.2020.
 * Loodos
 * onur.seref@loodos.com
 */

@Parcelize
data class WidgetsResponse(
    @SerializedName("widgets") val widgets: List<Widget>?
) : Parcelable

@Parcelize
data class Widget(
    @SerializedName("bannerContents") val bannerContents: List<BannerContent>?,
    @SerializedName("displayOrder") val displayOrder: Int?,
    @SerializedName("displayType") val displayType: String?,
    @SerializedName("eventKey") val eventKey: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("widgetNavigation") val widgetNavigation: WidgetNavigation?,
    @SerializedName("displayCount") val displayCount: Int = 0,
    @SerializedName("displayOptions") val displayOptions: DisplayOptions?,
    @SerializedName("startDate") val startDate: String?,
    @SerializedName("endDate") val endDate: String?,
    @SerializedName("marketing") val marketing: Marketing?,
    @SerializedName("refreshRequired") val refreshRequired: Boolean?,
    @SerializedName("products") val products: List<Product>?
) : Parcelable

@Parcelize
data class WidgetNavigation(
    @SerializedName("deeplink") val deeplink: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("landingTitle") val landingTitle: String?,
    @SerializedName("navigationType") val navigationType: String?
) : Parcelable

@Parcelize
data class Navigation(
    @SerializedName("deeplink") val deeplink: String?,
    @SerializedName("id") val id: Int?,
    @SerializedName("navigationType") val navigationType: String?
) : Parcelable

@Parcelize
data class DisplayOptions(
    @SerializedName("showProductPrice") val showProductPrice: Boolean?,
    @SerializedName("showProductFavoredButton") val showProductFavoredButton: Boolean?,
    @SerializedName("showClearButton") val showClearButton: Boolean?,
    @SerializedName("showCountdown") val showCountdown: Boolean?,
    @SerializedName("paddingTopBottom") val paddingTopBottom: Int?,
    @SerializedName("paddingRightLeft") val paddingRightLeft: Int?
) : Parcelable

@Parcelize
data class Delphoi(
    @SerializedName("tv068") val tv068: String?,
    @SerializedName("tv070") val tv070: String?,
    @SerializedName("tv072") val tv072: Int?,
    @SerializedName("tv073") val tv073: String?,
    @SerializedName("tv097") val tv097: String?
) : Parcelable

@Parcelize
data class BannerContent(
    @SerializedName("bannerEventKey") val bannerEventKey: String?,
    @SerializedName("displayOrder") val displayOrder: Int?,
    @SerializedName("height") val height: Int?,
    @SerializedName("imageUrl") val imageUrl: String?,
    @SerializedName("navigation") val navigation: Navigation?,
    @SerializedName("title") val title: String?,
    @SerializedName("width") val width: Int?,
    @SerializedName("bannerPosition") val bannerPosition: String?,
//    @SerializedName("marketing") val marketing: Marketing?
) : Parcelable

@Parcelize
data class Product(

    @SerializedName("boutiqueId") val boutiqueId: Int?,
    @SerializedName("brandId") val brandId: Int?,
    @SerializedName("brandName") val brandName: String?,
    @SerializedName("businessUnit") val businessUnit: String?,
    @SerializedName("categoryHierarchy") val categoryHierarchy: String?,
    @SerializedName("categoryId") val categoryId: Int?,
    @SerializedName("categoryName") val categoryName: String?,
    @SerializedName("colorId") val colorId: Int?,
    @SerializedName("colorName") val colorName: String?,
    @SerializedName("contentId") val contentId: Int?,
    @SerializedName("id") val id: Int?,
    @SerializedName("freeCargo") val freeCargo: Boolean?,
    @SerializedName("rushDelivery") val rushDelivery: Boolean?,
    @SerializedName("imageUrl") val imageUrl: String?,
    @SerializedName("imageUrls") val imageUrls: List<String>?,
    @SerializedName("mainId") val mainId: Int?,
    @SerializedName("marketPrice") val marketPrice: Double?,
    @SerializedName("name") val name: String?,
    @SerializedName("promotions") val promotions: List<String>?,
    @SerializedName("promotionMessage") val promotionMessage: String?,
    @SerializedName("salePrice") val salePrice: Double?,
    @SerializedName("discountedPrice") val discountedPrice: Double?,
    @SerializedName("discountedPriceInfo") val discountedPriceInfo: String?,
    @SerializedName("mOriginalPrice") val mOriginalPrice: Double?,
    @SerializedName("stockStatus") val stockStatus: Int?,
    @SerializedName("hasScheduledDelivery") val hasScheduledDelivery: Boolean?,
    @SerializedName("discountPercentage") val discountPercentage: String?,
    @SerializedName("promotionList") val promotionList: List<Promotion>?,
    @SerializedName("merchantId") val merchantId: Int?,
    @SerializedName("averageRating") val averageRating: Double?,
    @SerializedName("ratingCount") val ratingCount: Int?,
    @SerializedName("variants") val variants: List<Variant>?,
    @SerializedName("stamps") val stamps: List<Stamp>?,
    @SerializedName("isDirectCartAdditionAvailable") val isDirectCartAdditionAvailable: Boolean?,
    @SerializedName("isGroupColorOptionsActive") val isGroupColorOptionsActive: Boolean?,
    @SerializedName("marketing") val marketing: Marketing?
) : Parcelable

@Parcelize
data class Variant(

    @SerializedName("listingId") val listingId: String?,
    @SerializedName("variantId") val variantId: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("value") val value: String?,
    @SerializedName("campaignId") val campaignId: Int?,
    @SerializedName("price") val price: Price?
) : Parcelable

@Parcelize
data class Stamp(

    @SerializedName("imageUrl") val imageUrl: String?,
    @SerializedName("position") val position: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("aspectRatio") val aspectRatio: Double?
) : Parcelable

@Parcelize
data class Promotion(

    @SerializedName("name") val name: String?,
    @SerializedName("type") val type: String?
) : Parcelable

@Parcelize
data class Price(

    @SerializedName("salePrice") val salePrice: Double?,
    @SerializedName("marketPrice") val marketPrice: Double?
) : Parcelable


@Parcelize
data class Marketing(

    @SerializedName("facebook") val facebook: Facebook?,
    @SerializedName("delphoi") val delphoi: Delphoi?,
    @SerializedName("enhanced") val enhanced: Enhanced?
) : Parcelable

@Parcelize
data class Facebook(

    @SerializedName("quantity") val quantity: Int?,
    @SerializedName("product_itemnumber") val product_itemnumber: Int?,
    @SerializedName("item_price") val item_price: Double?,
    @SerializedName("product_listingid") val product_listingid: String?,
    @SerializedName("product_contentid") val product_contentid: Int?,
    @SerializedName("id") val id: Int?,
    @SerializedName("product_merchantid") val product_merchantid: Int?,
    @SerializedName("product_boutiqueid") val product_boutiqueid: Int?
) : Parcelable

@Parcelize
data class Enhanced(

    @SerializedName("dimension149") val dimension149: String?,
    @SerializedName("dimension140") val dimension140: Int?,
    @SerializedName("dimension141") val dimension141: Int?,
    @SerializedName("dimension152") val dimension152: Int?,
    @SerializedName("dimension142") val dimension142: String?,
    @SerializedName("dimension155") val dimension155: String?,
    @SerializedName("dimension145") val dimension145: Int?,
    @SerializedName("dimension156") val dimension156: String?,
    @SerializedName("dimension146") val dimension146: Int?,
    @SerializedName("dimension147") val dimension147: String?
) : Parcelable
