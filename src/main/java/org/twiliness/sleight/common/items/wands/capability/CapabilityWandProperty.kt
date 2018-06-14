package org.twiliness.sleight.common.items.wands.capability

import net.minecraft.nbt.NBTBase
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.EnumFacing
import net.minecraftforge.common.capabilities.Capability
import org.twiliness.sleight.common.items.wands.property.WandProperty

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
class CapabilityWandProperty {
    class Storage : Capability.IStorage<IWandProperty> {
        override fun readNBT(capability: Capability<IWandProperty>?, instance: IWandProperty?, side: EnumFacing?, nbt: NBTBase?) {
            val tag = nbt as NBTTagCompound
            val property = WandProperty.decode(tag)
            property?.let { instance?.set(it) }
        }

        override fun writeNBT(capability: Capability<IWandProperty>?, instance: IWandProperty?, side: EnumFacing?): NBTBase? {
            var tag: NBTTagCompound? = null
            instance?.get()?.let { tag = WandProperty.encode(it) }
            return tag
        }
    }

    class Impl : IWandProperty {
        private var property: WandProperty? = null
        override fun get(): WandProperty? {
            return property
        }

        override fun set(property: WandProperty) {
            this.property = property
        }
    }
}