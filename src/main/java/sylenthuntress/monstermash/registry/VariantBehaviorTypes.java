package sylenthuntress.monstermash.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registry;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehaviorType;
import sylenthuntress.monstermash.content.variant.behavior.type.ReaperVariantBehavior;

public class VariantBehaviorTypes {
    public static final VariantBehaviorType REAPER = register("reaper", ReaperVariantBehavior.CODEC);

    public static VariantBehaviorType register(String id, MapCodec<? extends VariantBehavior> codec) {
        return Registry.register(ModRegistries.VARIANT_BEHAVIOR_TYPES, MonsterMash.modIdentifier(id), new VariantBehaviorType(codec));
    }

    public static void registerAll() {

    }
}