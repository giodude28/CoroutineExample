package io.giodude.bbin.Network

import io.giodude.bbin.Model.TeamModel
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {

    @GET("chinasoccer")
    fun getTeam(): Single<List<TeamModel>>

}