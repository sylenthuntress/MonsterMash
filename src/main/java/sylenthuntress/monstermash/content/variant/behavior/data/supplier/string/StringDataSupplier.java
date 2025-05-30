package sylenthuntress.monstermash.content.variant.behavior.data.supplier.string;

import com.mojang.serialization.Codec;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.DataSupplier;
import sylenthuntress.monstermash.registry.ModRegistries;

public abstract class StringDataSupplier implements DataSupplier<String> {
    public static final Codec<StringDataSupplier> CODEC = ModRegistries.STRING_DATA_SUPPLIER_TYPES
            .getCodec()
            .dispatch(StringDataSupplier::getType, StringDataSupplierType::codec);

    public abstract StringDataSupplierType getType();
}
