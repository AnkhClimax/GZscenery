
package com.example.recyclersample.sceneryDetail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclersample.R
import com.example.recyclersample.sceneryList.SCENERY_ID

class SceneryDetailActivity : AppCompatActivity() {

    private val sceneryDetailViewModel by viewModels<SceneryDetailViewModel> {
        SceneryDetailViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scenery_detail_activity)

        var currentSceneryId: Long? = null

        val sceneryName: TextView = findViewById(R.id.scenery_detail_name)
        val sceneryImage: ImageView = findViewById(R.id.scenery_detail_image)
        val sceneryDescription: TextView = findViewById(R.id.scenery_detail_description)

        val bundle: Bundle? = intent.extras
        if (bundle != null) {
            currentSceneryId = bundle.getLong(SCENERY_ID)
        }

        currentSceneryId?.let {
            val currentScenery = sceneryDetailViewModel.getSceneryForId(it)
            sceneryName.text = currentScenery?.name
            if (currentScenery?.image == null) {
                sceneryImage.setImageResource(R.drawable.zjxc)
            } else {
                sceneryImage.setImageResource(currentScenery.image)
            }
            sceneryDescription.text = currentScenery?.description

        }

    }
}