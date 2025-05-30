package sylenthuntress.monstermash;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sylenthuntress.monstermash.registry.ModAttachmentTypes;
import sylenthuntress.monstermash.registry.ModRegistries;
import sylenthuntress.monstermash.registry.VariantBehaviorTypes;

public class MonsterMash implements ModInitializer {
    public static final String MOD_ID = "monstermash";
    public static final String MOD_NAME = "MonsterMash";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static Identifier modIdentifier(String id) {
        return Identifier.of(MOD_ID, id);
    }

    public void onInitialize() {
        MonsterMash.LOGGER.info(MOD_NAME + " successfully loaded!");

        ModRegistries.registerAll();
        VariantBehaviorTypes.registerAll();
        ModAttachmentTypes.registerAll();
    }
}