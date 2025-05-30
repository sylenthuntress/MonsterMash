package sylenthuntress.monstermash.content.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.context.LootWorldContext;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;

import java.util.Optional;

public record MobVariantTableEntry(RegistryEntry<MobVariant> variant, int weight, Optional<LootCondition> condition) {
    public final static Codec<MobVariantTableEntry> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    MobVariant.ENTRY_CODEC.fieldOf("variant").forGetter(MobVariantTableEntry::variant),
                    Codec.INT.fieldOf("weight").forGetter(MobVariantTableEntry::weight),
                    LootCondition.CODEC.optionalFieldOf("condition").forGetter(MobVariantTableEntry::condition)
            ).apply(instance, MobVariantTableEntry::new)
    );

    public boolean test(Entity entity) {
        if (condition.isEmpty() || !(entity.getWorld() instanceof ServerWorld serverWorld)) {
            return true;
        }

        LootWorldContext lootWorldContext = new LootWorldContext.Builder(serverWorld)
                .add(LootContextParameters.THIS_ENTITY, entity)
                .add(LootContextParameters.ORIGIN, entity.getPos())
                .build(LootContextTypes.COMMAND);
        LootContext lootContext = new LootContext.Builder(lootWorldContext).build(Optional.empty());

        return condition.get().test(lootContext);
    }
}
