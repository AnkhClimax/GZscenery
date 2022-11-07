
package com.example.recyclersample.sceneryList

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.recyclersample.data.DataSource

class ScenerysListViewModel(val dataSource: DataSource) : ViewModel() {

    val scenerysLiveData = dataSource.getSceneryList()


}

class ScenerysListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScenerysListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ScenerysListViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}