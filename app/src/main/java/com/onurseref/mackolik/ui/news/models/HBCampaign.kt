package com.onurseref.mackolik.ui.news.models

class HBCampaign(val campaignType: CampaignType){
    var title:String?=null
    var expDate:String?=null
    var width:Int?=null
    var height:Int?=null
    var url:String?=null
}

enum class CampaignType{
    HOT_DEAL,
    BANNER
}
