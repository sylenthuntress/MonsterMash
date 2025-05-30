package sylenthuntress.monstermash.content.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.TagEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.apache.commons.compress.utils.Lists;

import java.util.List;
import java.util.Optional;

public record MobVariantTable(TagEntry entity, int baseWeight, List<MobVariantTableEntry> entries) {
    public static final Codec<MobVariantTable> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    TagEntry.CODEC.fieldOf("entity").forGetter(MobVariantTable::entity),
                    Codec.INT.fieldOf("base_weight").forGetter(MobVariantTable::baseWeight),
                    MobVariantTableEntry.CODEC.listOf().fieldOf("table").forGetter(MobVariantTable::entries)
            ).apply(instance, MobVariantTable::new)
    );

    @SuppressWarnings("deprecation")
    public boolean includes(Entity entity) {
        String entryString = entity.toString().replaceAll("[?]", "");
        EntityType<?> entityType = entity.getType();

        return entryString.contains("#")
                ? entityType.getRegistryEntry().isIn(TagKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(entryString.substring(1))))
                : entityType.equals(Registries.ENTITY_TYPE.get(Identifier.of(entryString)));
    }

    public static Builder createEntity(EntityType<?> entityType) {
        return new Builder(TagEntry.create(EntityType.getId(entityType))
        );
    }

    public static Builder createTag(TagKey<EntityType<?>> tag) {
        return new Builder(TagEntry.createTag(tag.id()));
    }

    public static class Builder {
        private final List<MobVariantTableEntry> entries = Lists.newArrayList();
        private final TagEntry entity;

        Builder(TagEntry entity) {
            this.entity = entity;
        }

        public Builder addEntry(RegistryEntry<MobVariant> variant, int weight) {
            entries.add(new MobVariantTableEntry(variant, weight, Optional.empty()));
            return this;
        }

        public Builder addEntry(RegistryEntry<MobVariant> variant, int weight, LootCondition condition) {
            entries.add(new MobVariantTableEntry(variant, weight, Optional.of(condition)));
            return this;
        }

        public MobVariantTable build(int baseWeight) {
            return new MobVariantTable(entity, baseWeight, entries);
        }
    }
}
