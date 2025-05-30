package sylenthuntress.monstermash.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registry;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberSupplier;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberSupplierType;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.type.ConstantNumberSupplier;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.type.LastDamageDealtNumberSupplier;

public class DataSupplierTypes {
    public static final NumberSupplierType CONSTANT_NUMBER = registerNumber("constant_number", ConstantNumberSupplier.CODEC);
    public static final NumberSupplierType LAST_DAMAGE_DEALT = registerNumber("last_damage_dealt", LastDamageDealtNumberSupplier.CODEC);

    private static NumberSupplierType registerNumber(String id, MapCodec<? extends NumberSupplier> codec) {
        return Registry.register(ModRegistries.NUMBER_SUPPLIER_TYPES, MonsterMash.modIdentifier(id), new NumberSupplierType(codec));
    }

    public static void registerAll() {

    }
}