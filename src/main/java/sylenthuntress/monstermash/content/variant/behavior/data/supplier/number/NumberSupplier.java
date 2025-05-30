package sylenthuntress.monstermash.content.variant.behavior.data.supplier.number;

import com.mojang.serialization.Codec;
import sylenthuntress.monstermash.content.variant.behavior.action.ActionContext;
import sylenthuntress.monstermash.content.variant.behavior.data.supplier.DataSupplier;
import sylenthuntress.monstermash.registry.ModRegistries;

public abstract class NumberSupplier implements DataSupplier<Number> {
    public static final Codec<NumberSupplier> CODEC = ModRegistries.NUMBER_SUPPLIER_TYPES
            .getCodec()
            .dispatch(NumberSupplier::getType, NumberSupplierType::codec);

    public int intValue(ActionContext context) {
        return getValue(context).intValue();
    }

    public float floatValue(ActionContext context) {
        return getValue(context).floatValue();
    }

    public double doubleValue(ActionContext context) {
        return getValue(context).doubleValue();
    }

    public long longValue(ActionContext context) {
        return getValue(context).longValue();
    }

    public byte byteValue(ActionContext context) {
        return getValue(context).byteValue();
    }

    public abstract NumberSupplierType getType();
}
