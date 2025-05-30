package sylenthuntress.monstermash.registry;

import com.mojang.serialization.MapCodec;
import net.minecraft.registry.Registry;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.behavior.action.VariantAction;
import sylenthuntress.monstermash.content.variant.behavior.action.VariantActionType;
import sylenthuntress.monstermash.content.variant.behavior.action.type.HealVariantAction;

public class VariantActionTypes {
    public static final VariantActionType HEAL = register("heal", HealVariantAction.CODEC);

    public static VariantActionType register(String id, MapCodec<? extends VariantAction> codec) {
        return Registry.register(ModRegistries.VARIANT_ACTION_TYPES, MonsterMash.modIdentifier(id), new VariantActionType(codec));
    }

    public static void registerAll() {

    }
}