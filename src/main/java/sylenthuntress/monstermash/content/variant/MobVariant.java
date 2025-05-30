package sylenthuntress.monstermash.content.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.entry.RegistryFixedCodec;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;
import sylenthuntress.monstermash.registry.ModRegistries;

public record MobVariant(VariantBehavior behavior) {
    public static final Codec<MobVariant> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    VariantBehavior.CODEC.fieldOf("behavior").forGetter(MobVariant::behavior)
            ).apply(instance, MobVariant::new)
    );

    public static final Codec<RegistryEntry<MobVariant>> ENTRY_CODEC = RegistryFixedCodec.of(ModRegistries.MOB_VARIANTS);
}
