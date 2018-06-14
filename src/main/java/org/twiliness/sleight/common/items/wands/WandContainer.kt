package org.twiliness.sleight.common.items.wands

import net.minecraft.item.ItemStack
import net.minecraftforge.fml.common.registry.ForgeRegistries
import net.minecraftforge.oredict.ShapedOreRecipe
import org.twiliness.sleight.util.Recipe

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
object WandContainer {

    val woodenWand = WoodenWand()

    fun register() {
        register(woodenWand)
    }

    private fun register(wand: AbstractWand) {
        ForgeRegistries.ITEMS.register(woodenWand)
        registerRecipe(woodenWand)
    }

    private fun registerRecipe(wand: AbstractWand): Unit {
        val recipe = arrayOf(
                "  E",
                " B ",
                "H  ",
                'E',
                wand.material.rod_end,
                'B',
                wand.material.rod_body,
                'H',
                wand.material.rod_handle)
        val stack = ItemStack(wand)
        val shapedOreRecipe = ShapedOreRecipe(
                Recipe.getNameForRecipe(stack),
                stack,
                *recipe
        )
        shapedOreRecipe.registryName = Recipe.getNameForRecipe(stack)
        ForgeRegistries.RECIPES.register(
                shapedOreRecipe
        )
    }
}