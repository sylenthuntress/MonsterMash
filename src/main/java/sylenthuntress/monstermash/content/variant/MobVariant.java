package sylenthuntress.monstermash.content.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryFixedCodec;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;
import sylenthuntress.monstermash.registry.ModRegistryKeys;

public record MobVariant(VariantBehavior behavior) {
    public static final Codec<MobVariant> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    VariantBehavior.CODEC.fieldOf("behavior").forGetter(MobVariant::behavior)
            ).apply(instance, MobVariant::new)
    );

    public static final Codec<RegistryEntry<MobVariant>> ENTRY_CODEC = RegistryFixedCodec.of(ModRegistryKeys.MOB_VARIANTS);

    public static Builder create(VariantBehavior behavior) {
        return new Builder(behavior);
    }

    public static Builder create(VariantBehavior.Builder behavior) {
        return new Builder(behavior.build());
    }

    public static class Builder {
        private final VariantBehavior behavior;

        public Builder(VariantBehavior behavior) {
            this.behavior = behavior;
        }

        public MobVariant build() {
            return new MobVariant(behavior);
        }
    }
}
