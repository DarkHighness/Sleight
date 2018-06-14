package org.twiliness.sleight.common.items.wands.property

import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMap
import net.minecraft.client.resources.I18n
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
class WandProperty(val map: ImmutableMap<EnumProperty, Float>) {

    companion object {
        fun new(): WandPropertyTemp {
            return WandPropertyTemp()
        }

        fun decode(stack: ItemStack): WandProperty? {
            if (stack.hasTagCompound()) {
                val property = stack.tagCompound
                if (property != null) {
                    val tmp = WandProperty.new()
                    property.keySet.forEach {
                        tmp.with(EnumProperty.valueOf(it), property.getFloat(it))
                    }
                    return tmp.build()
                }
            }
            return null
        }

        fun decode(nbtTagCompound: NBTTagCompound): WandProperty? {
            val tmp = WandProperty.new()
            EnumProperty.values().forEach {
                tmp.with(it, nbtTagCompound.getFloat(it.name))
            }
            return tmp.build()
        }

        fun encode(property: WandProperty): NBTTagCompound {
            val compound = NBTTagCompound()
            property.map.forEach { key, value ->
                compound.setFloat(key.name, value)
            }
            return compound
        }
    }


    fun computeRate(): Float {
        var rate = 0.0f
        map.forEach { key, value ->
            rate += value * key.weight
        }
        return rate
    }

    fun generateTooltip(): ImmutableList<String> {
        val tmp = ImmutableList.builder<String>()
        map.forEach { key, value ->
            val str = "§c§l" + I18n.format("enum.wand_property.$key.name") + ": §r $value"
            tmp.add(str)
        }
        val rate = "§6§l" + I18n.format("enum.wand_property.rate.name") + ": ${computeRate()}"
        tmp.add(rate)
        return tmp.build()
    }

}