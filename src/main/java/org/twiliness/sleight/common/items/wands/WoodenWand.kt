package org.twiliness.sleight.common.items.wands

import org.twiliness.sleight.common.items.wands.material.WandMaterialFactory

/**
 * Created by Darkhighness on 2018/6/14 For Sleight.
 */
class WoodenWand : AbstractWand(WandMaterialFactory.WoodenWandMaterial) {

    init {
        name("wooden_wand")
    }
}