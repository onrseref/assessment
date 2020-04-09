package com.onurseref.mackolik.ui.news.domain

import com.onurseref.mackolik.common.models.NewsResponse
import com.onurseref.mackolik.data.service.Repository
import com.onurseref.mackolik.ui.news.viewstate.NewsViewState
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewsUseCase @Inject constructor(private val repository: Repository) {

    fun getNews(): Observable<NewsViewState> =
        repository.getNews()
            .subscribeOn(Schedulers.io())
            .map { getSuccessViewState(it) }
            .onErrorReturn { getFailViewState(it) }
            .startWith(NewsViewState.Loading)

    private fun getSuccessViewState(it: NewsResponse): NewsViewState {
        /*if (it.HBBanners.isNotEmpty() || it.HBHotDeals.isNotEmpty()) {
            val list = ArrayList<HBCampaign>()
            val count =
                if (it.HBBanners.size > it.HBHotDeals.size) it.HBBanners.size else it.HBHotDeals.size
            for (i in 0..count) {
                if (i + 1 < it.HBHotDeals.size) {
                    val c = HBCampaign(
                        CampaignType.HOT_DEAL
                    )
                    c.expDate = it.HBHotDeals[i].expirationDate
                    c.title = it.HBHotDeals[i].title
                    list.add(c)
                }
                if (i + 1 < it.HBBanners.size) {
                    val c = HBCampaign(
                        CampaignType.BANNER
                    )
                    c.width = it.HBBanners[i].hbImage.width
                    c.height = it.HBBanners[i].hbImage.height
                    c.url = it.HBBanners[i].hbImage.url
                    list.add(c)
                }
            }
            return MainGetCampaignsViewState.Success(list)
        } else {
            return MainGetCampaignsViewState.Error("Genel hata")
        }*/
        return NewsViewState.Error("Genel hata")
    }

    private fun getFailViewState(throwable: Throwable): NewsViewState {
        return NewsViewState.Error(throwable.localizedMessage)
    }
}