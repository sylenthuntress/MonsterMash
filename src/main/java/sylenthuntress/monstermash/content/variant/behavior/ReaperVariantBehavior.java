package sylenthuntress.monstermash.content.variant.behavior;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import sylenthuntress.monstermash.registry.VariantBehaviorTypes;

public record ReaperVariantBehavior(float lifestealRatio) implements VariantBehavior {
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
}
