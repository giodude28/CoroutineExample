package io.giodude.bbin.Model

import com.google.gson.annotations.SerializedName

data class TeamModel(

    @SerializedName("id")
    val id: Int?,
    @SerializedName("teamname_cn")
    val teamname: String?,
    @SerializedName("team_description")
    val teamdesc: String?,
    @SerializedName("team_badge")
    val teamimg: String?,
    @SerializedName("team_jersey")
    val teamjersey: String?,
    @SerializedName("team_formed_year")
    val teamyear: String?,
    @SerializedName("stadium")
    val teamstadium: String?,
    @SerializedName("staduim_image")
    val stadiumimg: String?,
    @SerializedName("stadium_description")
    val stadiumdesc: String?,
    @SerializedName("sports")
    val sports: String?,
    @SerializedName("league")
    val league: String?,
    @SerializedName("country")
    val country: String?,
)
