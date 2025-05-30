package sylenthuntress.monstermash.content.variant.behavior.data.supplier.string;

import com.mojang.serialization.Codec;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.DataSupplier;
import sylenthuntress.monstermash.registry.ModRegistries;

public abstract class StringSupplier implements DataSupplier<String> {
    public static final Codec<StringSupplier> CODEC = ModRegistries.STRING_SUPPLIER_TYPES
            .getCodec()
            .dispatch(StringSupplier::getType, StringSupplierType::codec);

    public abstract StringSupplierType getType();
}
