
package com.example.recyclersample.sceneryDetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclersample.data.DataSource
import com.example.recyclersample.data.Scenery

class SceneryDetailViewModel(private val datasource: DataSource) : ViewModel() {

    fun getSceneryForId(id: Long) : Scenery? {
        return datasource.getSceneryForId(id)
    }

}

class SceneryDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SceneryDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SceneryDetailViewModel(
                datasource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}