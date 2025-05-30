package sylenthuntress.monstermash.registry;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.MobVariant;
import sylenthuntress.monstermash.content.variant.MobVariantTable;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;

public class ModRegistryKeys {
    public static RegistryKey<Registry<VariantBehavior>> VARIANT_BEHAVIORS = RegistryKey.ofRegistry(
            MonsterMash.modIdentifier("variant_behavior")
    );

    public static RegistryKey<Registry<MobVariant>> MOB_VARIANTS = RegistryKey.ofRegistry(
            Identifier.of("mob_variants", "type")
    );

    public static RegistryKey<Registry<MobVariantTable>> MOB_VARIANT_TABLES = RegistryKey.ofRegistry(
            Identifier.of("mob_variants", "table")
    );
}
