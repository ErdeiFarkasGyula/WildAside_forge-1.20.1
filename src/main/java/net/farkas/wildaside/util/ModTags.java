package net.farkas.wildaside.util;

import net.farkas.wildaside.WildAside;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> VIBRION_GELS = tag("vibrion_gels");
        public static final TagKey<Block> VIBRION_FULL_GLASSES = tag("vibrion_full_glasses");
        public static final TagKey<Block> SUBSTILIUM_WOODSET = tag("substilium_woodset");
        public static final TagKey<Block> HUGE_MUSHROOM_GROW_BLOCK = tag("huge_mushroom_grow_block");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(WildAside.MOD_ID, name));
        }
    }

    public static class Items {

    }
}
