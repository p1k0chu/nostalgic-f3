package io.github.p1k0chu.nostalgic_f3.client.mixin;

import io.github.p1k0chu.nostalgic_f3.client.DebugScreenEntriesSides;
import net.minecraft.client.gui.components.debug.DebugScreenEntryList;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.Comparator;

@Mixin(DebugScreenEntryList.class)
public class DebugScreenEntryListMixin {
    @ModifyArg(method = "rebuildCurrentList", at = @At(value = "INVOKE", target = "Ljava/util/List;sort(Ljava/util/Comparator;)V"))
    Comparator<ResourceLocation> sort(Comparator<ResourceLocation> comparator) {
        return ((Comparator<ResourceLocation>) DebugScreenEntriesSides::compare).thenComparing(comparator);
    }
}
