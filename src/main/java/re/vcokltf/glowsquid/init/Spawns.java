package re.vcokltf.glowsquid.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableMap;
import re.vcokltf.glowsquid.entity.GlowSquidEntity;
import re.vcokltf.glowsquid.mixin.SpawnRestrictionAccessor;
import re.vcokltf.glowsquid.mixin.SpawnSettingsAccessor;

import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.biome.SpawnSettings.SpawnEntry;
import re.vcokltf.glowsquid.Glowsquid;


// big thanks to YanisBft with their MooBlooms mod! https://github.com/YanisBft/Mooblooms

public class Spawns {
    private static final Registry<Biome> REGISTRY = BuiltinRegistries.BIOME;

    public static void init() {
        registerSpawnRestrictions();

        for (Biome biome : BuiltinRegistries.BIOME) {
            if ((biome.equals(REGISTRY.get(BiomeKeys.DEEP_OCEAN))) ||
                    (biome.equals(REGISTRY.get(BiomeKeys.OCEAN))) ||
                    (biome.equals(REGISTRY.get(BiomeKeys.DEEP_LUKEWARM_OCEAN))) ||
                    (biome.equals(REGISTRY.get(BiomeKeys.DEEP_WARM_OCEAN))) ||
                    (biome.equals(REGISTRY.get(BiomeKeys.COLD_OCEAN))) ||
                    (biome.equals(REGISTRY.get(BiomeKeys.WARM_OCEAN))) ||
                    (biome.equals(REGISTRY.get(BiomeKeys.DEEP_COLD_OCEAN)))) {
                addSpawnToBiome(biome, new SpawnEntry(Glowsquid.GLOW_SQUID, 5, 3, 5));
                System.out.println(biome);
            }
        }
    }

    private static void addSpawnToBiome(Biome biome, SpawnSettings.SpawnEntry... spawners) {
        convertImmutableSpawners(biome);
        List<SpawnSettings.SpawnEntry> spawnersList = new ArrayList<>(((SpawnSettingsAccessor) biome.getSpawnSettings()).getSpawners().get(SpawnGroup.WATER_CREATURE));
        spawnersList.addAll(Arrays.asList(spawners));
        ((SpawnSettingsAccessor) biome.getSpawnSettings()).getSpawners().put(SpawnGroup.WATER_CREATURE, spawnersList);
    }

    private static void convertImmutableSpawners(Biome biome) {
        if (((SpawnSettingsAccessor) biome.getSpawnSettings()).getSpawners() instanceof ImmutableMap) {
            ((SpawnSettingsAccessor) biome.getSpawnSettings()).setSpawners(new HashMap<>(((SpawnSettingsAccessor) biome.getSpawnSettings()).getSpawners()));
        }
    }

    private static void registerSpawnRestrictions() {
        SpawnRestrictionAccessor.invokeRegister(Glowsquid.GLOW_SQUID, SpawnRestriction.Location.IN_WATER, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, GlowSquidEntity::canGlowquidSpawn);
    }
}