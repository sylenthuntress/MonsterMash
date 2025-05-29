package sylenthuntress.monstermash.content.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;

public record MobVariant(VariantBehavior behavior) {
    public static final Codec<MobVariant> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    VariantBehavior.CODEC.fieldOf("behavior").forGetter(MobVariant::behavior)
            ).apply(instance, MobVariant::new)
    );
}
