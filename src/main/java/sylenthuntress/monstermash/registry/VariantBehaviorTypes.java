package sylenthuntress.monstermash.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registry;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.behavior.ReaperVariantBehavior;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehaviorType;

public class VariantBehaviorTypes {
    public static final VariantBehaviorType REAPER = register("reaper", ReaperVariantBehavior.CODEC);

    public static VariantBehaviorType register(String id, MapCodec<? extends VariantBehavior> codec) {
        return Registry.register(ModRegistries.VARIANT_BEHAVIOR_TYPES, MonsterMash.modIdentifier("variant_behavior/" + id), new VariantBehaviorType(codec));
    }

    public static void registerAll() {

    }
}