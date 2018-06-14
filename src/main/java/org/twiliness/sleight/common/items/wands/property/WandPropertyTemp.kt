package org.twiliness.sleight.common.items.wands.property

import com.google.common.collect.ImmutableMap
import org.twiliness.sleight.Sleight

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
class WandPropertyTemp {
    val property = HashMap<EnumProperty, Float>()

    val logger = Sleight.instance.logger
    fun with(key: EnumProperty, value: Float) {

        if (property.containsKey(key)) {
            logger.warn("A WandProperty has been already registered?Might something go wrong!")
        } else {
            property[key] = value
        }
    }

    fun build(): WandProperty {
        val map = ImmutableMap.builder<EnumProperty, Float>()
        property.forEach { key, value ->
            if (value < key.min || value > key.max) {
                logger.warn("A WandProperty has out of its range!")
            } else {
                map.put(key, value)
            }
        }
        return WandProperty(map.build())
    }
}