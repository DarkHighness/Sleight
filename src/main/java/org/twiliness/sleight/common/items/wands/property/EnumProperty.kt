package org.twiliness.sleight.common.items.wands.property

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
enum class EnumProperty(val weight: Float, val min: Float, val max: Float) {
    CAST_STRENGTH(0.8f, 0f, 100f),
    CAST_SPEED(0.7f, 1.0f, 5.0f),
    CAST_COST_DECAY(0.5f, 0.05f, 5.0f),
    CAST_ELEMENT(0.0f, 0.0f, 1.0f)
}