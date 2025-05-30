package sylenthuntress.monstermash.content.variant;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryFixedCodec;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;
import sylenthuntress.monstermash.registry.ModRegistryKeys;

import java.util.List;

public record MobVariant(List<VariantBehavior> behavior) {
    public static final Codec<MobVariant> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    VariantBehavior.CODEC.listOf().fieldOf("behavior").forGetter(MobVariant::behavior)
            ).apply(instance, MobVariant::new)
    );

    public static final Codec<RegistryEntry<MobVariant>> ENTRY_CODEC = RegistryFixedCodec.of(ModRegistryKeys.MOB_VARIANTS);

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {
        private final List<VariantBehavior> behaviors = Lists.newArrayList();

        public Builder addBehavior(VariantBehavior behavior) {
            behaviors.add(behavior);
            return this;
        }

        public Builder addBehavior(VariantBehavior.Builder behavior) {
            behaviors.add(behavior.build());
            return this;
        }

        public MobVariant build() {
            return new MobVariant(behaviors);
        }
    }
}
