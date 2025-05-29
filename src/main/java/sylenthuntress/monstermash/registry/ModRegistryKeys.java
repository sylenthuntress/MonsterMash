package sylenthuntress.monstermash.registry;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;

public class ModRegistryKeys {
    public static RegistryKey<Registry<VariantBehavior>> VARIANT_BEHAVIORS = RegistryKey.ofRegistry(
            MonsterMash.modIdentifier("mob_variants")
    );
}
