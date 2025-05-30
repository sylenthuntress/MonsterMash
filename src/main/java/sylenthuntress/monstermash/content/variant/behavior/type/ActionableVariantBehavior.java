package sylenthuntress.monstermash.content.variant.behavior.type;

import sylenthuntress.monstermash.content.variant.behavior.VariantBehavior;
import sylenthuntress.monstermash.content.variant.behavior.action.ActionContext;
import sylenthuntress.monstermash.content.variant.behavior.action.VariantAction;

public interface ActionableVariantBehavior extends VariantBehavior {
    VariantAction action();

    default void execute(ActionContext context) {
        action().execute(context);
    }
}
