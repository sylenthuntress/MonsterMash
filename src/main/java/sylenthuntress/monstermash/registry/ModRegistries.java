package sylenthuntress.monstermash.registry;

import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.event.registry.DynamicRegistries;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import sylenthuntress.monstermash.content.variant.MobVariant;
import sylenthuntress.monstermash.content.variant.MobVariantTable;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehaviorType;

public class ModRegistries {
    public static Registry<VariantBehaviorType> VARIANT_BEHAVIOR_TYPES = registerSimple(ModRegistryKeys.VARIANT_BEHAVIOR_TYPES);
    public static RegistryKey<Registry<MobVariant>> MOB_VARIANTS = registerDynamic(ModRegistryKeys.MOB_VARIANTS, MobVariant.CODEC);
    public static RegistryKey<Registry<MobVariantTable>> MOB_VARIANT_TABLES = registerDynamic(ModRegistryKeys.MOB_VARIANT_TABLES, MobVariantTable.CODEC);

    public static <T> Registry<T> registerSimple(RegistryKey<Registry<T>> registryKey) {
        return FabricRegistryBuilder.createSimple(registryKey)
                .attribute(RegistryAttribute.OPTIONAL)
                .buildAndRegister();
    }

    private static <T> RegistryKey<Registry<T>> registerDynamic(RegistryKey<Registry<T>> registryKey, Codec<T> codec) {
        DynamicRegistries.register(registryKey, codec);
        return registryKey;
    }

    public static void registerAll() {

    }
}
