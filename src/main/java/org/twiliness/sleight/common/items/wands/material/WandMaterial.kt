package org.twiliness.sleight.common.items.wands.material

import org.twiliness.sleight.common.items.wands.property.EnumProperty
import org.twiliness.sleight.common.items.wands.property.WandProperty
import java.util.*

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
class WandMaterial {
    lateinit var rod_end: String
    lateinit var rod_body: String
    lateinit var rod_handle: String
    var material_data: HashMap<EnumProperty, Pair<Float, Float>> = HashMap()

    fun end(name: String): WandMaterial {
        this.rod_end = name
        return this
    }

    fun body(name: String): WandMaterial {
        this.rod_body = name
        return this
    }

    fun handle(name: String): WandMaterial {
        this.rod_handle = name
        return this
    }

    fun range(key: EnumProperty, min: Float, max: Float): WandMaterial {
        material_data[key] = Pair(min, max)
        return this
    }

    fun generateWandProperty(): WandProperty {
        val rand = Random()
        val temp = WandProperty.new()
        material_data.forEach { key, (min, max) ->
            val value = (rand.nextFloat() * (max - min)) + min
            val s = String.format("%.2f", value)
            temp.with(key, s.toFloat())
        }
        return temp.build()
    }
}