package sylenthuntress.monstermash.content.variant.behavior;

import com.mojang.serialization.MapCodec;

public record VariantBehaviorType(MapCodec<? extends VariantBehavior> codec) {
}
