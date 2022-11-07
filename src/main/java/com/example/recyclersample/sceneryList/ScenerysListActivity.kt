

package com.example.recyclersample.sceneryList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersample.sceneryDetail.SceneryDetailActivity
import com.example.recyclersample.R
import com.example.recyclersample.data.Scenery

const val SCENERY_ID = "scenery id"

class ScenerysListActivity : AppCompatActivity() {
    private val newSceneryActivityRequestCode = 1
    private val scenerysListViewModel by viewModels<ScenerysListViewModel> {
        ScenerysListViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val headerAdapter = HeaderAdapter()
        val scenerysAdapter = ScenerysAdapter { scenery -> adapterOnClick(scenery) }
        val concatAdapter = ConcatAdapter(headerAdapter, scenerysAdapter)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = concatAdapter

        scenerysListViewModel.scenerysLiveData.observe(this, {
            it?.let {
                scenerysAdapter.submitList(it as MutableList<Scenery>)
                headerAdapter.updateSceneryCount(it.size)
            }
        })

    }

    private fun adapterOnClick(scenery: Scenery) {
        val intent = Intent(this, SceneryDetailActivity()::class.java)
        intent.putExtra(SCENERY_ID, scenery.id)
        startActivity(intent)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)


    }
}