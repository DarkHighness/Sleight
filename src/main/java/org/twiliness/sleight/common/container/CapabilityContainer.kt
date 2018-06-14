package org.twiliness.sleight.common.container

import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.CapabilityInject
import net.minecraftforge.common.capabilities.CapabilityManager
import org.twiliness.sleight.common.items.wands.capability.CapabilityWandProperty
import org.twiliness.sleight.common.items.wands.capability.IWandProperty

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
object CapabilityContainer {
    @CapabilityInject(IWandProperty::class)
    var WandPropertyCapability: Capability<IWandProperty>? = null

    fun register() {
        CapabilityManager.INSTANCE.register(
                IWandProperty::class.java,
                CapabilityWandProperty.Storage(),
                CapabilityWandProperty::Impl)
    }
}