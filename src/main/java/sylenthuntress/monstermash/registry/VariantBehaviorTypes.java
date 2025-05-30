package sylenthuntress.monstermash.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registry;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehaviorType;
import sylenthuntress.monstermash.content.variant.behavior.type.ActionOnHitVariantBehavior;
import sylenthuntress.monstermash.content.variant.behavior.type.HealOnHitVariantBehavior;

public class VariantBehaviorTypes {
    public static final VariantBehaviorType HEAL_ON_HIT = register("heal_on_hit", HealOnHitVariantBehavior.CODEC);
    public static final VariantBehaviorType ACTION_ON_HIT = register("action_on_hit", ActionOnHitVariantBehavior.CODEC);

    public static VariantBehaviorType register(String id, MapCodec<? extends VariantBehavior> codec) {
        return Registry.register(ModRegistries.VARIANT_BEHAVIOR_TYPES, MonsterMash.modIdentifier(id), new VariantBehaviorType(codec));
    }

    public static void registerAll() {

    }
}