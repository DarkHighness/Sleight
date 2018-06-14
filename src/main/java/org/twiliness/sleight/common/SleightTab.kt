package org.twiliness.sleight.common

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.init.Blocks
import net.minecraft.item.ItemStack
import org.twiliness.sleight.Information
import org.twiliness.sleight.util.Factory

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
object SleightTab : CreativeTabs(
        Information.MOD_NAME
) {

    override fun getTabIconItem(): ItemStack {
        return Factory.ItemStack.new(Blocks.OBSIDIAN)
    }
}