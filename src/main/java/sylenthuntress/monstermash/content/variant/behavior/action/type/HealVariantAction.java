package sylenthuntress.monstermash.content.variant.behavior.action.type;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.LivingEntity;
import sylenthuntress.monstermash.content.variant.behavior.action.ActionContext;
import sylenthuntress.monstermash.content.variant.behavior.action.VariantAction;
import sylenthuntress.monstermash.content.variant.behavior.action.VariantActionType;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberSupplier;
import sylenthuntress.monstermash.registry.VariantActionTypes;

public record HealVariantAction(NumberSupplier healAmount) implements VariantAction {
    public static final MapCodec<HealVariantAction> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    NumberSupplier.CODEC.fieldOf("heal_amount").forGetter(HealVariantAction::healAmount)
            ).apply(instance, HealVariantAction::new)
    );

    @Override
    public void execute(ActionContext context) {
        if (!(context.getTargetEntity() instanceof LivingEntity targetEntity)) {
            return;
        }

        targetEntity.heal(healAmount.floatValue(context));
    }

    @Override
    public VariantActionType getType() {
        return VariantActionTypes.HEAL;
    }
}
