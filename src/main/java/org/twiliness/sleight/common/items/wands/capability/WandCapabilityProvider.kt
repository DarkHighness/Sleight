package org.twiliness.sleight.common.items.wands.capability

import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.ICapabilitySerializable
import org.twiliness.sleight.common.container.CapabilityContainer

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
class WandCapabilityProvider : ICapabilitySerializable<NBTTagCompound> {
    val impl = CapabilityWandProperty.Impl()
    val storage = CapabilityContainer.WandPropertyCapability?.storage

    override fun <T : Any?> getCapability(capability: Capability<T>, facing: EnumFacing?): T? {
        if (CapabilityContainer.WandPropertyCapability?.equals(capability)!!) {
            return impl as T
        }
        return null
    }

    override fun deserializeNBT(nbt: NBTTagCompound?) {
        val tag = nbt?.getCompoundTag("wand_property")
        storage?.readNBT(CapabilityContainer.WandPropertyCapability, impl, null, tag)
    }

    override fun serializeNBT(): NBTTagCompound {
        val compound = NBTTagCompound()
        compound.setTag("wand_property", storage?.writeNBT(
                CapabilityContainer.WandPropertyCapability,
                impl,
                null
        ))
        return compound
    }

    override fun hasCapability(capability: Capability<*>, facing: EnumFacing?): Boolean {
        return CapabilityContainer.WandPropertyCapability!!.equals(capability)
    }
}