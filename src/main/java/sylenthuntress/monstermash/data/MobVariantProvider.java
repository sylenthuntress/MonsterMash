package sylenthuntress.monstermash.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.MobVariant;
import sylenthuntress.monstermash.content.variant.behavior.type.ReaperVariantBehavior;
import sylenthuntress.monstermash.registry.ModRegistryKeys;

import java.util.concurrent.CompletableFuture;

public class MobVariantProvider extends FabricDynamicRegistryProvider {
    public MobVariantProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static RegistryKey<MobVariant> registryKey(String id) {
        return RegistryKey.of(ModRegistryKeys.MOB_VARIANTS,
                MonsterMash.modIdentifier(id)
        );
    }

    public static void bootstrapEntries(Registerable<MobVariant> registerable) {
        Variants.REAPER = registerable.register(registryKey("reaper"),
                MobVariant.create(ReaperVariantBehavior.create()).build()
        );
    }

    @Override
    public String getName() {
        return "mob_variants:variant";
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getOrThrow(ModRegistryKeys.MOB_VARIANTS));
    }

    public static class Variants {
        public static RegistryEntry<MobVariant> REAPER;
    }
}
