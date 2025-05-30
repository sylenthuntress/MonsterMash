package sylenthuntress.monstermash.content.variant.behavior.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehaviorType;
import sylenthuntress.monstermash.registry.VariantBehaviorTypes;

public record ReaperVariantBehavior(float lifestealRatio) implements AttackingVariantBehavior {
    public static final MapCodec<ReaperVariantBehavior> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Codec.FLOAT.optionalFieldOf("lifesteal_ratio", 1.0F).forGetter(ReaperVariantBehavior::lifestealRatio)
            ).apply(instance, ReaperVariantBehavior::new)
    );

    @Override
    public void afterAttack(ServerWorld world, LivingEntity attacker, Entity target, float amount) {
        attacker.heal(amount * lifestealRatio);
    }

    @Override
    public VariantBehaviorType getType() {
        return VariantBehaviorTypes.REAPER;
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder implements VariantBehavior.Builder {
        private float lifestealRatio = 1.0F;

        public Builder setLifestealRatio(float newRatio) {
            this.lifestealRatio = newRatio;
            return this;
        }

        @Override
        public VariantBehavior build() {
            return new ReaperVariantBehavior(lifestealRatio);
        }
    }
}
