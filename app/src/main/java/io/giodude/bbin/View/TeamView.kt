package io.giodude.bbin.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.giodude.bbin.Adapter.TeamAdapter
import io.giodude.bbin.Model.TeamModel
import io.giodude.bbin.R
import io.giodude.bbin.ViewModel.ViewModels

class TeamView : AppCompatActivity() {

    lateinit var viewModel: ViewModels
    lateinit var rvItem: RecyclerView
    var rviData = ArrayList<TeamModel>()
    private var arrayList: ArrayList<TeamModel>? = null
    var itemAdapter = this?.let { TeamAdapter(it, arrayListOf()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_view)
        rvItem = findViewById(R.id.recyclerView)
        viewModel = ViewModelProvider(this).get(ViewModels::class.java)
        viewModel.teamData()
        rvItem.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        itemViewModel()
    }

    fun itemViewModel() {

        viewModel.item.observe(this, Observer { itemdata ->
            rviData.clear()
            for (item in itemdata!!) {
                rviData.add(item)
                Log.d("Data", rviData.size.toString())
            }

            arrayList = ArrayList()
            arrayList = rviData
            itemAdapter = this?.let { TeamAdapter(it, arrayList!!) }
            rvItem.adapter = itemAdapter
        })
    }
}