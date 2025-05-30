package sylenthuntress.monstermash.content.variant.behavior.action;

import com.mojang.serialization.Codec;
import sylenthuntress.monstermash.registry.ModRegistries;

public interface VariantAction {
    Codec<VariantAction> CODEC = ModRegistries.VARIANT_ACTION_TYPES
            .getCodec()
            .dispatch(VariantAction::getType, VariantActionType::codec);

    void execute(ActionContext context);

    VariantActionType getType();

    @FunctionalInterface
    interface Builder {
        VariantAction build();
    }
}
