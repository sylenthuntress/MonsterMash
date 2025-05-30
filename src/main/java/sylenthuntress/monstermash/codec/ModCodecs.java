package sylenthuntress.monstermash.codec;

import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.PrimitiveCodec;

public class ModCodecs {
    public static final PrimitiveCodec<Number> NUMBER = new PrimitiveCodec<>() {
        public <T> DataResult<Number> read(DynamicOps<T> ops, T input) {
            return ops.getNumberValue(input);
        }

        public <T> T write(DynamicOps<T> ops, Number value) {
            return ops.createDouble(value.doubleValue());
        }

        public String toString() {
            return "Number";
        }
    };
}
