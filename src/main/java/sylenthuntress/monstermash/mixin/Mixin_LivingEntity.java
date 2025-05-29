package sylenthuntress.monstermash.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import sylenthuntress.monstermash.content.variant.MobVariant;
import sylenthuntress.monstermash.util.VariantHelper;

@Mixin(LivingEntity.class)
public class Mixin_LivingEntity {
    @WrapMethod(method = "tryAttack")
    public boolean onHitVariant(ServerWorld world, Entity target, Operation<Void> original) {
        MobVariant variant = VariantHelper.getVariant((LivingEntity) (Object) this);
        if (variant != null && !variant.behavior().onHit(world, target)) {
            return false;
        }

        original.call(world, target);
        return false;
    }
}
