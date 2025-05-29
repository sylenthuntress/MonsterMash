package sylenthuntress.monstermash.registry;

import net.fabricmc.fabric.api.attachment.v1.AttachmentRegistry;
import net.fabricmc.fabric.api.attachment.v1.AttachmentType;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.MobVariant;

@SuppressWarnings("UnstableApiUsage")
public class ModAttachmentTypes {
    public static AttachmentType<MobVariant> MOB_VARIANT = AttachmentRegistry.create(
            MonsterMash.modIdentifier("mob_variant"),
            builder -> builder
                    .initializer(() -> null)
                    .persistent(MobVariant.CODEC)
                    .copyOnDeath()
    );

    public static void registerAll() {

    }
}
