package io.giodude.bbin.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.giodude.bbin.Model.TeamModel
import io.giodude.bbin.Network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class ViewModels: ViewModel() {


    private val apiService = ApiService()
    private val disposable = CompositeDisposable()
    val teamdata = MutableLiveData<List<TeamModel>>()
    val homeLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()
    val item : LiveData<List<TeamModel>> get() = teamdata

    fun teamData(){
        getTeam()
    }

    private fun getTeam(){
        disposable.add(
            apiService.getTeams()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<TeamModel>>() {
                    override fun onSuccess(t: List<TeamModel>) {
                        teamdata.value = t
                        homeLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        homeLoadError.value = true
                        loading.value = false
                    }
                })
        )
    }
}