package sylenthuntress.monstermash.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.registry.Registry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sylenthuntress.monstermash.content.variant.MobVariantTable;
import sylenthuntress.monstermash.content.variant.MobVariantTableEntry;
import sylenthuntress.monstermash.registry.ModRegistries;
import sylenthuntress.monstermash.util.VariantHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Mixin(EntityType.class)
public class Mixin_EntityType<T extends Entity> {
    @Inject(
            method = "spawn(Lnet/minecraft/server/world/ServerWorld;Ljava/util/function/Consumer;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/entity/SpawnReason;ZZ)Lnet/minecraft/entity/Entity;",
            at = @At("TAIL")
    )
    public void selectVariant(ServerWorld world, @Nullable Consumer<T> afterConsumer, BlockPos pos, SpawnReason reason,
                              boolean alignPosition, boolean invertY, CallbackInfoReturnable<T> cir, @Local Entity entity) {
        Registry<MobVariantTable> tables = world.getRegistryManager().getOrThrow(ModRegistries.MOB_VARIANT_TABLES);
        if (!(entity instanceof LivingEntity livingEntity)) {
            return;
        }

        for (MobVariantTable table : tables) {
            if (!table.includes(entity)) {
                continue;
            }

            List<MobVariantTableEntry> entries = new ArrayList<>(
                    table.entries().stream().filter(entry -> entry.test(entity)).toList());
            entries.add(MobVariantTableEntry.getEmpty(table.baseWeight()));

            int totalWeight = entries.stream().mapToInt(MobVariantTableEntry::weight).sum();

            int tableSize = entries.size();
            if (totalWeight != 0) {
                if (tableSize == 1) {
                    VariantHelper.setVariant(livingEntity, entries.getFirst().variant().value());
                } else {
                    int i = entity.getRandom().nextInt(totalWeight);

                    for (MobVariantTableEntry entry : entries) {
                        i -= entry.weight();
                        if (i < 0) {
                            VariantHelper.setVariant(livingEntity, entry.variant().value());
                            return;
                        }
                    }
                }
            }
        }
    }
}
