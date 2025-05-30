package sylenthuntress.monstermash.content.variant.behavior;

import com.mojang.serialization.Codec;
import sylenthuntress.monstermash.registry.ModRegistries;

public interface VariantBehavior {
    Codec<VariantBehavior> CODEC = ModRegistries.VARIANT_BEHAVIOR_TYPES
            .getCodec()
            .dispatch(VariantBehavior::getType, VariantBehaviorType::codec);

    VariantBehaviorType getType();

    @FunctionalInterface
    interface Builder {
        VariantBehavior build();
    }
}
