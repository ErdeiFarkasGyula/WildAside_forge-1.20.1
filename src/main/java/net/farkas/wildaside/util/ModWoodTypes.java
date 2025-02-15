package net.farkas.wildaside.util;

import net.farkas.wildaside.WildAside;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

public class ModWoodTypes {
    public static final WoodType SUBSTILIUM = WoodType.register(new WoodType(WildAside.MOD_ID + ":substilium", BlockSetType.OAK));
    public static final WoodType HICKORY = WoodType.register(new WoodType(WildAside.MOD_ID + ":hickory", BlockSetType.OAK));
    public static final WoodType CYPRESS = WoodType.register(new WoodType(WildAside.MOD_ID + ":cypress", BlockSetType.OAK));
}
