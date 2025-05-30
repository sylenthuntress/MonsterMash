package sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.type;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import sylenthuntress.monstermash.codec.ModCodecs;
import sylenthuntress.monstermash.content.variant.behavior.action.ActionContext;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberDataSupplier;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.number.NumberDataSupplierType;
import sylenthuntress.monstermash.registry.DataSupplierTypes;

public class ConstantNumberDataSupplier extends NumberDataSupplier {
    public static final MapCodec<ConstantNumberDataSupplier> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    ModCodecs.NUMBER.fieldOf("value").forGetter(ConstantNumberDataSupplier::getValue)
            ).apply(instance, ConstantNumberDataSupplier::new)
    );

    private final Number value;

    public ConstantNumberDataSupplier(Number value) {
        this.value = value;
    }

    @Override
    public NumberDataSupplierType getType() {
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
