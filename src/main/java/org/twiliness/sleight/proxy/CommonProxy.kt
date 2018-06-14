package org.twiliness.sleight.proxy

import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.twiliness.sleight.common.container.BlockContainer
import org.twiliness.sleight.common.container.CapabilityContainer
import org.twiliness.sleight.common.container.ItemContainer
import org.twiliness.sleight.common.items.wands.WandContainer


/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
open class CommonProxy {
    open fun preInit(event: FMLPreInitializationEvent) {
        ItemContainer.register()
        BlockContainer.register()
        WandContainer.register()
        CapabilityContainer.register()
    }

    open fun init(event: FMLInitializationEvent) {

    }

    open fun postInit(event: FMLPostInitializationEvent) {

    }
}