package org.twiliness.sleight

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.SidedProxy
import net.minecraftforge.fml.common.event.FMLInitializationEvent
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent
import org.apache.logging.log4j.Logger
import org.twiliness.sleight.proxy.CommonProxy
import kotlin.properties.Delegates

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */

@Mod(
        name = Information.MOD_NAME,
        modid = Information.MOD_ID,
        version = Information.MOD_VERSION
)
class Sleight {

    companion object {
        @Mod.Instance
        lateinit var instance: Sleight

        @SidedProxy(
                serverSide = Information.MOD_PROXY_PACKAGE + ".CommonProxy",
                clientSide = Information.MOD_PROXY_PACKAGE + ".ClientProxy"
        )
        lateinit var proxy: CommonProxy
    }

    var logger by Delegates.notNull<Logger>()

    @Mod.EventHandler
    fun preInit(event: FMLPreInitializationEvent) {
        logger = event.modLog
        proxy.preInit(event)
    }

    @Mod.EventHandler
    fun init(event: FMLInitializationEvent) {
        proxy.init(event)
    }

    @Mod.EventHandler
    fun postInit(event: FMLPostInitializationEvent) {
        proxy.postInit(event)
    }

}