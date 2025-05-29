package sylenthuntress.monstermash.registry;

import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;

public class ModRegistries {
    public static Registry<VariantBehavior> VARIANT_BEHAVIORS = registerSimple(ModRegistryKeys.VARIANT_BEHAVIORS);

    public static <T> Registry<T> registerSimple(RegistryKey<Registry<T>> registryKey) {
        return FabricRegistryBuilder.createSimple(registryKey).buildAndRegister();
    }

    public static void registerAll() {

    }
}
