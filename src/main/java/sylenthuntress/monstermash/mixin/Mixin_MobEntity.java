package sylenthuntress.monstermash.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sylenthuntress.monstermash.content.variant.MobVariant;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;
import sylenthuntress.monstermash.content.variant.behavior.type.AttackingVariantBehavior;
import sylenthuntress.monstermash.registry.ModAttachmentTypes;
import sylenthuntress.monstermash.util.VariantHelper;

@Mixin(MobEntity.class)
public abstract class Mixin_MobEntity extends LivingEntity {
    protected Mixin_MobEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @WrapMethod(method = "tryAttack")
    public boolean onHitVariant(ServerWorld world, Entity target, Operation<Boolean> original) {
        MobVariant variant = VariantHelper.getVariant(this);
        if (variant != null) {
            for (VariantBehavior behavior : variant.behavior()) {
                if (behavior instanceof AttackingVariantBehavior attackingBehavior) {
                    ActionResult result = attackingBehavior.tryAttack(world, this, target);
                    if (result == ActionResult.FAIL) {
                        return false;
                    }

                    if (result == ActionResult.SUCCESS) {
                        original.call(world, target);
                        return true;
                    }
                }
            }
        }

        return original.call(world, target);
    }

    @Inject(
            method = "tryAttack",
            at = @At("TAIL")
    )
    public void onHitVariant(ServerWorld world, Entity target, CallbackInfoReturnable<Boolean> cir, @Local(ordinal = 0) float amount) {
        //noinspection UnstableApiUsage
        this.setAttached(ModAttachmentTypes.LAST_DAMAGE_DEALT, amount);

        MobVariant variant = VariantHelper.getVariant(this);
        if (variant != null) {
            for (VariantBehavior behavior : variant.behavior()) {
                if (behavior instanceof AttackingVariantBehavior attackingBehavior) {
                    attackingBehavior.afterAttack(world, this, target, amount);
                }
            }
        }
    }
}
