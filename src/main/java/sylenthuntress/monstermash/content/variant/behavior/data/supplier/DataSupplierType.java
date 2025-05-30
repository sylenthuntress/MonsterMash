package sylenthuntress.monstermash.content.variant.behavior.data.supplier;

import com.mojang.serialization.MapCodec;

public interface DataSupplierType<T> {
    MapCodec<? extends DataSupplier<T>> codec();
}
