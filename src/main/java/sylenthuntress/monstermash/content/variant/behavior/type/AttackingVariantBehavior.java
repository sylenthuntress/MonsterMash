package sylenthuntress.monstermash.content.variant.behavior.type;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;

public interface AttackingVariantBehavior extends VariantBehavior {
    /**
     * Override to inject custom behavior into the tryAttack action of this variant.
     */
    default ActionResult tryAttack(ServerWorld world, LivingEntity attacker, Entity target) {
        return ActionResult.PASS;
    }

    default void afterAttack(ServerWorld world, LivingEntity attacker, Entity target, float amount) {
    }
}
