package org.twiliness.sleight.common.items.wands.message

import io.netty.buffer.ByteBuf
import net.minecraft.nbt.NBTTagCompound
import net.minecraftforge.fml.common.network.ByteBufUtils
import net.minecraftforge.fml.common.network.simpleimpl.IMessage
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext
import net.minecraftforge.fml.relauncher.Side

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
class MessageWandProperty : IMessage {
    var compound: NBTTagCompound? = null
    override fun fromBytes(buf: ByteBuf?) {
        compound = ByteBufUtils.readTag(buf)
    }

    override fun toBytes(buf: ByteBuf?) {
        ByteBufUtils.writeTag(buf, compound)
    }

    class Handler : IMessageHandler<MessageWandProperty, IMessage> {
        override fun onMessage(message: MessageWandProperty?, ctx: MessageContext?): IMessage? {
            if (ctx?.side == Side.CLIENT) {
                val compound = message?.compound
            }
            return null
        }
    }
}