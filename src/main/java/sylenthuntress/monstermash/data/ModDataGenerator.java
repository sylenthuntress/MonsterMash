package sylenthuntress.monstermash.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import sylenthuntress.monstermash.registry.ModRegistryKeys;

public class ModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        pack.addProvider(MobVariantProvider::new);
        pack.addProvider(MobVariantTableProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);
        registryBuilder.addRegistry(ModRegistryKeys.MOB_VARIANTS, MobVariantProvider::bootstrapEntries);
        registryBuilder.addRegistry(ModRegistryKeys.MOB_VARIANT_TABLES, MobVariantTableProvider::bootstrapEntries);
    }
}
