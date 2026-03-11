package io.github.p1k0chu.nostalgic_f3.client;

import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public final class DebugScreenEntriesSides {
    private DebugScreenEntriesSides() {
    }

    private static final List<ResourceLocation> leftSide = List.of(
            ResourceLocation.withDefaultNamespace("game_version"),
            ResourceLocation.withDefaultNamespace("fps"),
            ResourceLocation.withDefaultNamespace("tps"), // integrated server...
            ResourceLocation.withDefaultNamespace("chunk_render_stats"), // c counter
            ResourceLocation.withDefaultNamespace("entity_render_stats"), // e counter
            ResourceLocation.withDefaultNamespace("particle_render_stats"), // p counter
            ResourceLocation.withDefaultNamespace("chunk_source_stats"), // chunks[c] and chunks[s]

            ResourceLocation.withDefaultNamespace("player_position"),
            ResourceLocation.withDefaultNamespace("light_levels"),
            ResourceLocation.withDefaultNamespace("heightmap"), // CH + SH
            ResourceLocation.withDefaultNamespace("biome"),
            ResourceLocation.withDefaultNamespace("local_difficulty"),
            ResourceLocation.withDefaultNamespace("chunk_generation_stats"), // noise router + biome builder
            ResourceLocation.withDefaultNamespace("entity_spawn_counts"), // SC
            ResourceLocation.withDefaultNamespace("sound_mood"),
            ResourceLocation.withDefaultNamespace("post_effect"),
            ResourceLocation.withDefaultNamespace("player_section_position")
    );

    private static final List<ResourceLocation> rightSide = List.of(
            ResourceLocation.withDefaultNamespace("memory"),
            ResourceLocation.withDefaultNamespace("system_specs"),
            ResourceLocation.withDefaultNamespace("gpu_utilization"),
            ResourceLocation.withDefaultNamespace("simple_performance_impactors"),

            ResourceLocation.withDefaultNamespace("looking_at_block"),
            ResourceLocation.withDefaultNamespace("looking_at_fluid"),
            ResourceLocation.withDefaultNamespace("looking_at_entity")
    );

    public static int compare(ResourceLocation left, ResourceLocation right) {
        int res = leftSide.indexOf(left) - leftSide.indexOf(right);
        if (res != 0) return res;

        return rightSide.indexOf(left) - rightSide.indexOf(right);
    }

    public static SidedDebugScreenDisplayer.@Nullable Side getSide(ResourceLocation id) {
        if (leftSide.contains(id)) return SidedDebugScreenDisplayer.Side.LEFT;
        if (rightSide.contains(id)) return SidedDebugScreenDisplayer.Side.RIGHT;
        return null;
    }
}
