package sylenthuntress.monstermash.content.variant.behavior.data.supplier.number;

import com.mojang.serialization.MapCodec;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.DataSupplierType;

public record NumberDataSupplierType(MapCodec<? extends NumberDataSupplier> codec) implements DataSupplierType<Number> {
}
