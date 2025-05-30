package sylenthuntress.monstermash.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.EntityTypeTags;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.MobVariantTable;
import sylenthuntress.monstermash.registry.ModRegistryKeys;

import java.util.concurrent.CompletableFuture;

public class MobVariantTableProvider extends FabricDynamicRegistryProvider {
    public MobVariantTableProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static RegistryKey<MobVariantTable> registryKey(String id) {
        return RegistryKey.of(ModRegistryKeys.MOB_VARIANT_TABLES,
                MonsterMash.modIdentifier(id)
        );
    }

    public static void bootstrapEntries(Registerable<MobVariantTable> registerable) {
        registerable.register(registryKey("skeletons"),
                MobVariantTable.createTag(EntityTypeTags.SKELETONS)
                        .addEntry(MobVariantProvider.Variants.REAPER, 10)
                        .build(10)
        );
    }

    @Override
    public String getName() {
        return "mob_variants:table";
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
        entries.addAll(registries.getOrThrow(ModRegistryKeys.MOB_VARIANT_TABLES));
    }
}
