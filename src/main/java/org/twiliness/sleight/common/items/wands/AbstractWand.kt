package org.twiliness.sleight.common.items.wands

import net.minecraft.client.util.ITooltipFlag
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.world.World
import net.minecraftforge.common.capabilities.ICapabilityProvider
import org.twiliness.sleight.common.container.CapabilityContainer
import org.twiliness.sleight.common.items.SleightItem
import org.twiliness.sleight.common.items.wands.capability.WandCapabilityProvider
import org.twiliness.sleight.common.items.wands.material.WandMaterial
import org.twiliness.sleight.common.items.wands.property.EnumProperty

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
abstract class AbstractWand(val material: WandMaterial) : SleightItem() {

    init {
        this.maxStackSize = 1
    }

    override fun onCreated(stack: ItemStack?, worldIn: World?, playerIn: EntityPlayer?) {
        super.onCreated(stack, worldIn, playerIn)
        if (!worldIn!!.isRemote) {
            val property = material.generateWandProperty()
            if (CapabilityContainer.WandPropertyCapability?.let { stack?.hasCapability(it, null) }!!) {
                val capability = stack?.getCapability(CapabilityContainer.WandPropertyCapability!!, null)
                if (capability?.get()?.map?.get(EnumProperty.CAST_STRENGTH) == 0.0f) {
                    capability.set(property)
                }
            }
            playerIn?.inventoryContainer?.detectAndSendChanges()
        }
    }


    override fun initCapabilities(stack: ItemStack?, nbt: NBTTagCompound?): ICapabilityProvider? {
        return WandCapabilityProvider()
    }

    override fun addInformation(stack: ItemStack?, worldIn: World?, tooltip: MutableList<String>?, flagIn: ITooltipFlag?) {
//        WandProperty.decode(stack)?.generateTooltip()?.let { tooltip?.addAll(it) }
        if (CapabilityContainer.WandPropertyCapability?.let { stack?.hasCapability(it, null) }!!) {
            val property = stack?.getCapability(CapabilityContainer.WandPropertyCapability!!, null)
            val wandProperty = property?.get()
            if (wandProperty != null) {
                val list = wandProperty?.generateTooltip()
                tooltip?.addAll(list)
            }
        }
    }
}