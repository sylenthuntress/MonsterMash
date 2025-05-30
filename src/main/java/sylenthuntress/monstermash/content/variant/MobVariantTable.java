package sylenthuntress.monstermash.content.variant;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagEntry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.List;

public record MobVariantTable(TagEntry entity, List<MobVariantTableEntry> entries) {
    public static final Codec<MobVariantTable> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                    TagEntry.CODEC.fieldOf("entity").forGetter(MobVariantTable::entity),
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
}
