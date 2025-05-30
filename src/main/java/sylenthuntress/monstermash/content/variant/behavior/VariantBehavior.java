package sylenthuntress.monstermash.content.variant.behavior;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.serialization.Codec;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import sylenthuntress.monstermash.registry.ModRegistries;

public interface VariantBehavior {
    Codec<VariantBehavior> CODEC = ModRegistries.VARIANT_BEHAVIOR_TYPES
            .getCodec()
            .dispatch(VariantBehavior::getType, VariantBehaviorType::codec);

    /**
     * Override to inject custom behavior into the tryAttack action of this variant.
     * Return false to override normal behavior.
     */
    default boolean tryAttack(ServerWorld world, LivingEntity attacker, Entity target, Operation<Void> original) {
        original.call(world, target);
        return true;
    }

    default void afterAttack(ServerWorld world, LivingEntity attacker, Entity target, float amount) {
    }

    VariantBehaviorType getType();
}
