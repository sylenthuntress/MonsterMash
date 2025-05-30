package sylenthuntress.monstermash.content.variant.behavior.type;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.predicate.NumberRange;
import net.minecraft.server.world.ServerWorld;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehaviorType;
import sylenthuntress.monstermash.registry.VariantBehaviorTypes;

public record HealOnHitVariantBehavior(NumberRange.DoubleRange healAmount,
                                       float lifestealRatio) implements AttackingVariantBehavior {
    public static final MapCodec<HealOnHitVariantBehavior> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    NumberRange.DoubleRange.CODEC.optionalFieldOf("heal_amount", NumberRange.DoubleRange.ANY).forGetter(HealOnHitVariantBehavior::healAmount),
                    Codec.FLOAT.optionalFieldOf("lifesteal_ratio", 0.0F).forGetter(HealOnHitVariantBehavior::lifestealRatio)
            ).apply(instance, HealOnHitVariantBehavior::new)
    );

    @Override
    public void afterAttack(ServerWorld world, LivingEntity attacker, Entity target, float amount) {
        float healAmount = amount * lifestealRatio;
        healAmount += attacker.getRandom().nextBetween(
                (int) Math.round(healAmount().min().orElse(0D) * 1000),
                (int) Math.round(healAmount().max().orElse(0D) * 1000)
        ) * 0.001F;

        attacker.heal(healAmount);
    }

    @Override
    public VariantBehaviorType getType() {
        return VariantBehaviorTypes.HEAL_ON_HIT;
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder implements VariantBehavior.Builder {
        private NumberRange.DoubleRange healAmount = NumberRange.DoubleRange.ANY;
        private float lifestealRatio = 0.0F;

        public Builder setLifestealRatio(float newRatio) {
            this.lifestealRatio = newRatio;
            return this;
        }

        public Builder setHealAmount(double value) {
            healAmount = NumberRange.DoubleRange.exactly(value);
            return this;
        }

        public Builder setHealAmount(double minValue, double maxValue) {
            healAmount = NumberRange.DoubleRange.between(minValue, maxValue);
            return this;
        }

        @Override
        public VariantBehavior build() {
            return new HealOnHitVariantBehavior(healAmount, lifestealRatio);
        }
    }
}
