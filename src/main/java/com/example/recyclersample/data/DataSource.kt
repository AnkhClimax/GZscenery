
package com.example.recyclersample.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources) {
    private val initialSceneryList = sceneryList(resources)
    private val scenerysLiveData = MutableLiveData(initialSceneryList)


    fun getSceneryForId(id: Long): Scenery? {
        scenerysLiveData.value?.let { scenerys ->
            return scenerys.firstOrNull{ it.id == id}
        }
        return null
    }

    fun getSceneryList(): LiveData<List<Scenery>> {
        return scenerysLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}