package org.twiliness.sleight.common.items

import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import org.twiliness.sleight.Information
import org.twiliness.sleight.common.SleightTab

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
open class SleightItem : Item() {
    fun name(name: String): Item {
        val itemName = "${Information.MOD_ID}.$name"
        this.unlocalizedName = itemName
        this.registryName = ResourceLocation(Information.MOD_ID, itemName)
        return this
    }

    init {
        this.creativeTab = SleightTab
    }
}