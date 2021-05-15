package io.giodude.bbin.Network

import io.giodude.bbin.Model.TeamModel
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    private val TeamApi: ApiInterface

    init {
        TeamApi = Retrofit.Builder()
            .baseUrl("http://45.66.164.9:7566/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(io.giodude.bbin.Network.ApiInterface::class.java)
    }

    fun getTeams(): Single<List<TeamModel>> {
        return TeamApi.getTeam()
    }
}