package sylenthuntress.monstermash.registry;

import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.MobVariant;
import sylenthuntress.monstermash.content.variant.behavior.data.VariantData;

import java.util.Map;

@SuppressWarnings("UnstableApiUsage")
public class ModAttachmentTypes {
    public static AttachmentType<MobVariant> MOB_VARIANT = AttachmentRegistry.create(
            MonsterMash.modIdentifier("mob_variant"),
            builder -> builder
                    .initializer(() -> null)
                    .persistent(MobVariant.CODEC)
                    .copyOnDeath()
    );

    public static AttachmentType<Map<RegistryEntry<MobVariant>, Map<Identifier, VariantData<?>>>> VARIANT_DATA = AttachmentRegistry.create(
            MonsterMash.modIdentifier("variant_data"),
            builder -> builder
                    .initializer(Maps::newHashMap)
                    .persistent(Codec.unboundedMap(MobVariant.ENTRY_CODEC, Codec.unboundedMap(Identifier.CODEC, VariantData.CODEC)))
                    .copyOnDeath()
    );

    public static void registerAll() {

    }
}
