package sylenthuntress.monstermash.content.variant.behavior.data.supplier.string;

import com.mojang.serialization.MapCodec;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.DataSupplierType;

public record StringDataSupplierType(MapCodec<? extends StringDataSupplier> codec) implements DataSupplierType<String> {
}
