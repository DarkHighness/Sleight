package org.twiliness.sleight.common.items.wands.material

import org.twiliness.sleight.common.items.wands.property.EnumProperty

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
object WandMaterialFactory {
    fun new(): WandMaterial {
        return WandMaterial()
    }

    val WoodenWandMaterial = new()
            .end("logWood")
            .body("logWood")
            .handle("stickWood")
            .range(EnumProperty.CAST_STRENGTH, 1f, 10f)
            .range(EnumProperty.CAST_COST_DECAY, 2.0f, 2.5f)
            .range(EnumProperty.CAST_ELEMENT, 0.0f, 1.0f)
            .range(EnumProperty.CAST_SPEED, 1.25f, 1.5f)
}