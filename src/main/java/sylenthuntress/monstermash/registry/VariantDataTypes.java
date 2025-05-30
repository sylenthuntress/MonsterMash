package sylenthuntress.monstermash.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registry;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.behavior.data.VariantData;
import sylenthuntress.monstermash.content.variant.behavior.data.VariantDataType;
import sylenthuntress.monstermash.content.variant.behavior.data.type.NumberVariantData;
import sylenthuntress.monstermash.content.variant.behavior.data.type.StringVariantData;

public class VariantDataTypes {
    public static final VariantDataType NUMBER = register("number", NumberVariantData.CODEC);
    public static final VariantDataType STRING = register("string", StringVariantData.CODEC);

    private static VariantDataType register(String id, MapCodec<? extends VariantData<?>> codec) {
        return Registry.register(ModRegistries.VARIANT_DATA_TYPES, MonsterMash.modIdentifier(id), new VariantDataType(codec));
    }

    public static void registerAll() {

    }
}