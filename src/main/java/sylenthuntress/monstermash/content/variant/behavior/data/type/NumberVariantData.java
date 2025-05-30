package sylenthuntress.monstermash.content.variant.behavior.data.type;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import sylenthuntress.monstermash.codec.ModCodecs;
import sylenthuntress.monstermash.content.variant.behavior.data.VariantData;
import sylenthuntress.monstermash.content.variant.behavior.data.VariantDataType;
import sylenthuntress.monstermash.registry.VariantDataTypes;

public class NumberVariantData extends VariantData<Number> {
    public static final MapCodec<NumberVariantData> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    ModCodecs.NUMBER.fieldOf("value").forGetter(VariantData::getValue)
            ).apply(instance, NumberVariantData::new)
    );

    NumberVariantData(Number value) {
        super(value);
    }

    @Override
    public VariantDataType getType() {
        return VariantDataTypes.NUMBER;
    }
}
