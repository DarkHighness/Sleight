package org.twiliness.sleight.common.items.wands.capability

import org.twiliness.sleight.common.items.wands.property.WandProperty

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
interface IWandProperty {
    fun get(): WandProperty?
    fun set(property: WandProperty)
}