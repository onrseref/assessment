package com.onurseref.marvel.common.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ScoresResponse(
    @SerializedName("gsmrs") val gsmrs: Gsmrs?
) : Parcelable

@Parcelize
data class Gsmrs(
    @SerializedName("method") val method: Method?,
    @SerializedName("competition") val competition: Competition?,
    @SerializedName("_version") val _version: Double?,
    @SerializedName("_sport") val _sport: String?,
    @SerializedName("_lang") val _lang: String?,
    @SerializedName("_last_generated") val _last_generated: String?
) : Parcelable

@Parcelize
data class Group(
    @SerializedName("match") val match: List<Match>?,
    @SerializedName("_group_id") val _group_id: Int?,
    @SerializedName("_name") val _name: String?,
    @SerializedName("_details") val _details: String?,
    @SerializedName("_winner") val _winner: String?,
    @SerializedName("_last_updated") val _last_updated: String?
) : Parcelable

@Parcelize
data class Competition(
    @SerializedName("season") val season: Season?,
    @SerializedName("_competition_id") val _competition_id: Int?,
    @SerializedName("_name") val _name: String?,
    @SerializedName("_teamtype") val _teamtype: String?,
    @SerializedName("_display_order") val _display_order: Int?,
    @SerializedName("_type") val _type: String?,
    @SerializedName("_area_id") val _area_id: Int?,
    @SerializedName("_area_name") val _area_name: String?,
    @SerializedName("_last_updated") val _last_updated: String?,
    @SerializedName("_soccertype") val _soccertype: String?
) : Parcelable

@Parcelize
data class Match(
    @SerializedName("_match_id") val _match_id: Int?,
    @SerializedName("_date_utc") val _date_utc: String?,
    @SerializedName("_time_utc") val _time_utc: String?,
    @SerializedName("_date_london") val _date_london: String?,
    @SerializedName("_time_london") val _time_london: String?,
    @SerializedName("_team_A_id") val _team_A_id: Int?,
    @SerializedName("_team_A_name") val _team_A_name: String?,
    @SerializedName("_team_A_country") val _team_A_country: String?,
    @SerializedName("_team_B_id") val _team_B_id: Int?,
    @SerializedName("_team_B_name") val _team_B_name: String?,
    @SerializedName("_team_B_country") val _team_B_country: String?,
    @SerializedName("_status") val _status: String?,
    @SerializedName("_gameweek") val _gameweek: Int?,
    @SerializedName("_winner") val _winner: String?,
    @SerializedName("_fs_A") val _fs_A: Int?,
    @SerializedName("_fs_B") val _fs_B: Int?,
    @SerializedName("_hts_A") val _hts_A: String?,
    @SerializedName("_hts_B") val _hts_B: String?,
    @SerializedName("_ets_A") val _ets_A: String?,
    @SerializedName("_ets_B") val _ets_B: String?,
    @SerializedName("_ps_A") val _ps_A: String?,
    @SerializedName("_ps_B") val _ps_B: String?,
    @SerializedName("_last_updated") val _last_updated: String?
) : Parcelable

@Parcelize
data class Method(
    @SerializedName("parameter") val parameter: List<Parameter>?,
    @SerializedName("_method_id") val _method_id: Int?,
    @SerializedName("_name") val _name: String?
) : Parcelable

@Parcelize
data class Parameter(
    @SerializedName("_name") val _name: String?,
    @SerializedName("_value") val _value: String?
) : Parcelable

@Parcelize
data class Round(
    @SerializedName("group") val group: List<Group>?,
    @SerializedName("_round_id") val _round_id: Int?,
    @SerializedName("_name") val _name: String?,
    @SerializedName("_start_date") val _start_date: String?,
    @SerializedName("_end_date") val _end_date: String?,
    @SerializedName("_type") val _type: String?,
    @SerializedName("_groups") val _groups: Int?,
    @SerializedName("_has_outgroup_matches") val _has_outgroup_matches: String?,
    @SerializedName("_last_updated") val _last_updated: String?
) : Parcelable

@Parcelize
data class Season(
    @SerializedName("round") val round: Round?,
    @SerializedName("_season_id") val _season_id: Int?,
    @SerializedName("_name") val _name: String?,
    @SerializedName("_start_date") val _start_date: String?,
    @SerializedName("_end_date") val _end_date: String?,
    @SerializedName("_service_level") val _service_level: Int?,
    @SerializedName("_last_updated") val _last_updated: String?
) : Parcelable
