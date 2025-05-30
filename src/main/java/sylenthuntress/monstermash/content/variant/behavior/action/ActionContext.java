package sylenthuntress.monstermash.content.variant.behavior.action;

import net.minecraft.entity.Entity;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.context.ContextParameter;
import net.minecraft.util.context.ContextParameterMap;
import net.minecraft.util.context.ContextType;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.include.com.google.common.collect.Lists;
import sylenthuntress.monstermash.MonsterMash;
import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;

import java.util.List;

public class ActionContext {
    private static final ContextType THIS = new ContextType.Builder()
            .require(ContextParameters.ORIGIN_ENTITY)
            .allow(ContextParameters.TARGET_ENTITY)
            .allow(ContextParameters.ORIGIN_POS)
            .allow(ContextParameters.TARGET_POS)
            .allow(ContextParameters.BEHAVIOR_ENTRY)
            .build();

    private final ContextParameterMap parameters;

    private ActionContext(ContextParameterMap parameters) {
        this.parameters = parameters;
    }

    public static Builder create() {
        return new Builder();
    }

    public static Builder create(ActionContext source) {
        Builder builder = new Builder();
        for (ContextParameter<?> parameter : ContextParameters.ALL_PARAMETERS) {
            if (!source.parameters.contains(parameter)) {
                continue;
            }

            builder.addParameter(parameter, source);
        }

        return builder;
    }

    public Entity getOriginEntity() {
        return parameters.getOrThrow(ContextParameters.ORIGIN_ENTITY);
    }

    public Entity getTargetEntity() {
        return parameters.getOrDefault(
                ContextParameters.TARGET_ENTITY,
                parameters.getOrThrow(ContextParameters.ORIGIN_ENTITY)
        );
    }

    public Vec3d getTargetPos() {
        return parameters.getOrDefault(
                ContextParameters.TARGET_POS,
                parameters.getOrDefault(
                        ContextParameters.ORIGIN_POS,
                        getTargetEntity().getPos()
                )
        );
    }

    public static class Builder {
        private ContextParameterMap.Builder parameters;

        public <T> Builder addParameter(ContextParameter<T> parameter, T value) {
            parameters.add(parameter, value);
            return this;
        }

        public <T> Builder addParameter(ContextParameter<T> parameter, ActionContext source) {
            parameters.add(parameter, source.parameters.getOrThrow(parameter));
            return this;
        }

        public <T> Builder addNullable(ContextParameter<T> parameter, T value) {
            parameters.addNullable(parameter, value);
            return this;
        }

        public ActionContext build() {
            return new ActionContext(parameters.build(THIS));
        }
    }

    private static class ContextParameters {
        public static final List<ContextParameter<?>> ALL_PARAMETERS = Lists.newArrayList();

        public static final ContextParameter<Entity> ORIGIN_ENTITY = of("entity/origin");
        public static final ContextParameter<Entity> TARGET_ENTITY = of("entity/target");
        public static final ContextParameter<Vec3d> ORIGIN_POS = of("pos/origin");
        public static final ContextParameter<Vec3d> TARGET_POS = of("pos/target");
        public static final ContextParameter<RegistryEntry<VariantBehavior>> BEHAVIOR_ENTRY = of("behavior_entry");

        private static <T> ContextParameter<T> of(String id) {
            ContextParameter<T> parameter = new ContextParameter<>(MonsterMash.modIdentifier(id));
            ALL_PARAMETERS.add(parameter);
            return parameter;
        }
    }
}
