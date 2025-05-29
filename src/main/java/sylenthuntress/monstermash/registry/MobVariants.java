package sylenthuntress.monstermash.registry;

import net.minecraft.registry.Registry;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.VariantBehavior;
import sylenthuntress.monstermash.content.variant.skeleton.ReaperVariantBehavior;

public class MobVariants {
    public static VariantBehavior register(String id, VariantBehavior variant) {
        return Registry.register(ModRegistries.VARIANT_BEHAVIORS, MonsterMash.modIdentifier("variant/" + id), variant);
    }

    public static void registerAll() {

    }

    public static class SkeletonVariants {
        public static final VariantBehavior REAPER = register("reaper", new ReaperVariantBehavior());

        public static VariantBehavior register(String id, VariantBehavior variant) {
            return MobVariants.register("skeleton/" + id, variant);
        }
    }
}