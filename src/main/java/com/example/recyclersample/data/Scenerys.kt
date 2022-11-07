

package com.example.recyclersample.data

import android.content.res.Resources
import com.example.recyclersample.R


fun sceneryList(resources: Resources): List<Scenery> {
    return listOf(
        Scenery(
            id = 1,
            name = resources.getString(R.string.scenery1_name),
            image = R.drawable.zjxc,
            description = resources.getString(R.string.scenery1_description)
        ),
        Scenery(
            id = 2,
            name = resources.getString(R.string.scenery2_name),
            image = R.drawable.gzt,
            description = resources.getString(R.string.scenery2_description)
        ),
        Scenery(
            id = 3,
            name = resources.getString(R.string.scenery3_name),
            image = R.drawable.njs,
            description = resources.getString(R.string.scenery3_description)
        ),
        Scenery(
            id = 4,
            name = resources.getString(R.string.scenery4_name),
            image = R.drawable.hpjx,
            description = resources.getString(R.string.scenery4_description)
        ),
        Scenery(
            id = 5,
            name = resources.getString(R.string.scenery5_name),
            image = R.drawable.zsjnt,
            description = resources.getString(R.string.scenery5_description)
        ),
        Scenery(
            id = 6,
            name = resources.getString(R.string.scenery6_name),
            image = R.drawable.yxgy,
            description = resources.getString(R.string.scenery6_description)
        ),
        Scenery(
            id = 7,
            name = resources.getString(R.string.scenery7_name),
            image = R.drawable.hcgc,
            description = resources.getString(R.string.scenery7_description)
        ),
        Scenery(
            id = 8,
            name = resources.getString(R.string.scenery8_name),
            image = R.drawable.lzw,
            description = resources.getString(R.string.scenery8_description)
        )
    )
}