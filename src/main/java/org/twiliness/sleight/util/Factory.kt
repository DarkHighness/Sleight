package org.twiliness.sleight.util

import net.minecraft.block.Block
import net.minecraft.item.Item
import net.minecraft.item.ItemStack

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
object Factory {
    object ItemStack {

        fun new(block: Block): net.minecraft.item.ItemStack {
            return ItemStack(block, 1, 0)
        }

        fun new(block: Block, amount: Int): net.minecraft.item.ItemStack {
            return ItemStack(block, amount, 0)
        }

        fun new(block: Block, amount: Int, metadata: Int): net.minecraft.item.ItemStack {
            return ItemStack(block, amount, metadata)
        }

        fun new(item: Item): net.minecraft.item.ItemStack {
            return new(item, 1, 0)
        }

        fun new(item: Item, amount: Int): net.minecraft.item.ItemStack {
            return new(item, amount, 0)
        }

        fun new(item: Item, amount: Int, metadata: Int): net.minecraft.item.ItemStack {
            return ItemStack(item, amount, metadata)
        }
    }
}