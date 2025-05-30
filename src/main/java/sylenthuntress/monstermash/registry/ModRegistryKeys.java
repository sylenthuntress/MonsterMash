package sylenthuntress.monstermash.registry;

import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.MobVariant;
import sylenthuntress.monstermash.content.variant.MobVariantTable;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehaviorType;
import sylenthuntress.monstermash.content.variant.behavior.action.VariantActionType;
import sylenthuntress.monstermash.content.variant.behavior.data.VariantDataType;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberDataSupplierType;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.string.StringDataSupplierType;

public class ModRegistryKeys {
    public static RegistryKey<Registry<VariantBehaviorType>> VARIANT_BEHAVIOR_TYPES = RegistryKey.ofRegistry(
            MonsterMash.modIdentifier("variant_behavior_type")
    );

    public static RegistryKey<Registry<VariantActionType>> VARIANT_ACTION_TYPES = RegistryKey.ofRegistry(
            MonsterMash.modIdentifier("variant_action_type")
    );

    public static RegistryKey<Registry<VariantDataType>> VARIANT_DATA_TYPES = RegistryKey.ofRegistry(
            MonsterMash.modIdentifier("variant_data_type")
    );

    public static RegistryKey<Registry<NumberDataSupplierType>> NUMBER_DATA_SUPPLIER_TYPES = RegistryKey.ofRegistry(
            MonsterMash.modIdentifier("data_supplier_type/number")
    );

    public static RegistryKey<Registry<StringDataSupplierType>> STRING_DATA_SUPPLIER_TYPES = RegistryKey.ofRegistry(
            MonsterMash.modIdentifier("data_supplier_type/string")
    );

    public static RegistryKey<Registry<MobVariant>> MOB_VARIANTS = RegistryKey.ofRegistry(
            Identifier.of("mob_variants", "type")
    );

    public static RegistryKey<Registry<MobVariantTable>> MOB_VARIANT_TABLES = RegistryKey.ofRegistry(
            Identifier.of("mob_variants", "table")
    );
}
