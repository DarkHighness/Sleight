package org.twiliness.sleight.util

import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.CraftingManager
import net.minecraft.util.ResourceLocation
import org.twiliness.sleight.Information


/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
object Recipe {
    fun getNameForRecipe(output: ItemStack): ResourceLocation {
        val baseLoc = ResourceLocation(
                Information.MOD_ID,
                output.getItem().getRegistryName()?.getResourcePath()
        )
        var recipeLoc = baseLoc
        var index = 0
        while (CraftingManager.REGISTRY.containsKey(recipeLoc)) {
            index++
            recipeLoc = ResourceLocation(Information.MOD_ID, baseLoc.resourcePath + "_" + index)
        }
        return recipeLoc
    }
}