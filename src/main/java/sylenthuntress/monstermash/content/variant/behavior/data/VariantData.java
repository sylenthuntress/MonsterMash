package sylenthuntress.monstermash.content.variant.behavior.data;

import com.mojang.serialization.Codec;
import sylenthuntress.monstermash.registry.ModRegistries;

import java.util.function.Function;

public abstract class VariantData<T> {
    public static final Codec<VariantData<?>> CODEC = ModRegistries.VARIANT_DATA_TYPES
            .getCodec()
            .dispatch(VariantData::getType, VariantDataType::codec);

    private T value;

    protected VariantData(T value) {
        this.value = value;
    }

    public abstract VariantDataType getType();

    public T getValue() {
        return value;
    }

    public T setValue(T newValue) {
        return value = newValue;
    }

    public T modifyValue(Function<T, T> modifier) {
        return value = modifier.apply(value);
    }
}
