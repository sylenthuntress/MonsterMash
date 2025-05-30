package sylenthuntress.monstermash.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registry;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberDataSupplier;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberDataSupplierType;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.type.ConstantNumberDataSupplier;

public class DataSupplierTypes {
    public static final NumberDataSupplierType CONSTANT_NUMBER = registerNumber("constant_number", ConstantNumberDataSupplier.CODEC);

    public static NumberDataSupplierType registerNumber(String id, MapCodec<? extends NumberDataSupplier> codec) {
        return Registry.register(ModRegistries.NUMBER_DATA_SUPPLIER_TYPES, MonsterMash.modIdentifier(id), new NumberDataSupplierType(codec));
    }

    public static void registerAll() {

    }
}