package sylenthuntress.monstermash.content.variant.behavior.data.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import sylenthuntress.monstermash.content.variant.behavior.data.VariantData;
import sylenthuntress.monstermash.content.variant.behavior.data.VariantDataType;
import sylenthuntress.monstermash.registry.VariantDataTypes;

public class StringVariantData extends VariantData<String> {
    public static final MapCodec<StringVariantData> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.STRING.fieldOf("value").forGetter(VariantData::getValue)
            ).apply(instance, StringVariantData::new)
    );

    StringVariantData(String value) {
        super(value);
    }

    @Override
    public VariantDataType getType() {
        return VariantDataTypes.STRING;
    }
}
