package org.twiliness.sleight.wand.property

/**
 * Created by Darkhighness on 2018/6/15 For Sleight.
 */
class WandProperty {
    data class Result(val error: Boolean, val property: WandProperty, val error_msg: List<String>)

    var map = HashMap<Property<Any>, Any>()

    fun with(property: Property<Any>, value: Any): WandProperty {
        this.map[property] = value
        return this
    }

    fun build(): Result {
        var error = false
        var list = ArrayList<String>()
        map.forEach { k, v ->
            if (!k.valid(v)) {
                error = true
                list.add("${k.property_name} with value $v")
            }
        }
        return Result(error, this, list)
    }
}