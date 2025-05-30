package sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import sylenthuntress.monstermash.content.variant.behavior.action.ActionContext;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberSupplier;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberSupplierType;
import sylenthuntress.monstermash.registry.DataSupplierTypes;
import sylenthuntress.monstermash.registry.ModAttachmentTypes;

public class LastDamageDealtNumberSupplier extends NumberSupplier {
    public static final MapCodec<LastDamageDealtNumberSupplier> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.FLOAT.optionalFieldOf("factor", 1.0F).forGetter(LastDamageDealtNumberSupplier::getFactor)
            ).apply(instance, LastDamageDealtNumberSupplier::new)
    );

    private final float factor;

    public LastDamageDealtNumberSupplier(float factor) {
        this.factor = factor;
    }

    @Override
    public NumberSupplierType getType() {
        return DataSupplierTypes.LAST_DAMAGE_DEALT;
    }

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public Number getValue(ActionContext context) {
        return context.getOriginEntity().getAttachedOrElse(ModAttachmentTypes.LAST_DAMAGE_DEALT, 1.0F);
    }

    public float getFactor() {
        return factor;
    }
}
