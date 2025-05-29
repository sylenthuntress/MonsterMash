package sylenthuntress.monstermash.content.variant.behavior;

import com.mojang.serialization.Codec;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import sylenthuntress.monstermash.registry.ModRegistries;

public abstract class VariantBehavior {
    public static final Codec<VariantBehavior> CODEC = ModRegistries.VARIANT_BEHAVIORS.getCodec();

    /**
     * Override to inject custom behavior into the onHit action of this variant.
     * Return false to override normal behavior.
     */
    public boolean onHit(ServerWorld world, Entity target) {
        return true;
    }
}
