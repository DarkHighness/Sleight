package org.twiliness.sleight.wand.property

/**
 * Created by Darkhighness on 2018/6/15 For Sleight.
 */

sealed class Property<T>(
        val property_name: String,
        val property_range: Pair<T, T>,
        val property_weight: Float
) {
    class FloatProperty(name: String, range: Pair<Float, Float>, weight: Float) : Property<Float>(name, range, weight)
    class IntProperty(name: String, range: Pair<Int, Int>, weight: Float) : Property<Int>(name, range, weight)

    fun valid(value: T): Boolean {
        if (value is Int) {
            val v = value as Int
            val min = property_range.first as Int
            val max = property_range.second as Int
            if (v in (min + 1)..(max - 1)) return true
        }

        if (value is Float) {
            val v = value as Float
            val min = property_range.first as Float
            val max = property_range.second as Float
            if (v in (min + 1)..(max - 1)) return true
        }
        return false
    }

    companion object {
        val CAST_STRENGTH = FloatProperty("CAST_STRENGTH", Pair(0.0f, 100.0f), 0.8f)
        val CAST_SPEED = FloatProperty("CAST_SPEED", Pair(0.05f, 10.0f), 0.6f)
        val CAST_COST_DECAY = FloatProperty("CAST_COST_DECAY", Pair(0.05f, 10.0f), 0.6f)
        val CAST_ELEMENT = IntProperty("CAST_ELEMENT", Pair(0, Element.values().size), 0.0f)
    }
}