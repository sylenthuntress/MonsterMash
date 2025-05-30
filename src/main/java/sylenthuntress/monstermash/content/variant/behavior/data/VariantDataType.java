package sylenthuntress.monstermash.content.variant.behavior.data;

import com.mojang.serialization.MapCodec;

public record VariantDataType(MapCodec<? extends VariantData<?>> codec) {
}
