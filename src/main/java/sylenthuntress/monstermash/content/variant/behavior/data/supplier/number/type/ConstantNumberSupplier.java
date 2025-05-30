package sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.type;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import sylenthuntress.monstermash.codec.ModCodecs;
import sylenthuntress.monstermash.content.variant.behavior.action.ActionContext;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberSupplier;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberSupplierType;
import sylenthuntress.monstermash.registry.DataSupplierTypes;

public class ConstantNumberSupplier extends NumberSupplier {
    public static final MapCodec<ConstantNumberSupplier> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    ModCodecs.NUMBER.fieldOf("value").forGetter(ConstantNumberSupplier::getValue)
            ).apply(instance, ConstantNumberSupplier::new)
    );

    public final Number value;

    public ConstantNumberSupplier(Number value) {
        this.value = value;
    }

    @Override
    public NumberSupplierType getType() {
        return DataSupplierTypes.CONSTANT_NUMBER;
    }

    @Override
    public Number getValue(ActionContext context) {
        return getValue();
    }

    public Number getValue() {
        return value;
    }
}
