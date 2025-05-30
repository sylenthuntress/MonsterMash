package sylenthuntress.monstermash.util;

import net.minecraft.entity.LivingEntity;
import sylenthuntress.monstermash.content.variant.MobVariant;
import sylenthuntress.monstermash.registry.ModAttachmentTypes;

@SuppressWarnings("UnstableApiUsage")
public class VariantHelper {
    public static MobVariant getVariant(LivingEntity entity) {
        return entity.getAttached(ModAttachmentTypes.MOB_VARIANT);
    }

    public static void setVariant(LivingEntity entity, MobVariant variant) {
        if (variant == null) {
            return;
        }

        entity.setAttached(ModAttachmentTypes.MOB_VARIANT, variant);
    }
}
