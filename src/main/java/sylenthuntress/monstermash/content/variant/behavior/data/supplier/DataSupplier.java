package sylenthuntress.monstermash.content.variant.behavior.data.supplier;

import sylenthuntress.monstermash.content.variant.behavior.action.ActionContext;

public interface DataSupplier<T> {
    T getValue(ActionContext context);
}
