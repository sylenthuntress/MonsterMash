package sylenthuntress.monstermash.content.variant.behavior.action;

import com.mojang.serialization.MapCodec;

public record VariantActionType(MapCodec<? extends VariantAction> codec) {
}
