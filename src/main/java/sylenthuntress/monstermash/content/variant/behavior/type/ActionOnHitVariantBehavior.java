package sylenthuntress.monstermash.content.variant.behavior.type;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehaviorType;
import sylenthuntress.monstermash.content.variant.behavior.action.VariantAction;
import sylenthuntress.monstermash.registry.VariantBehaviorTypes;

public record ActionOnHitVariantBehavior(VariantAction action) implements ActionableVariantBehavior {
    public final static MapCodec<ActionOnHitVariantBehavior> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    VariantAction.CODEC.fieldOf("action").forGetter(ActionOnHitVariantBehavior::action)
            ).apply(instance, ActionOnHitVariantBehavior::new)
    );

    @Override
    public VariantBehaviorType getType() {
        return VariantBehaviorTypes.ACTION_ON_HIT;
    }
}
