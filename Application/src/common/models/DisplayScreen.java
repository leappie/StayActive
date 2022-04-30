package common.models;

import common.enums.Display;
import common.interfaces.Displayable;

public class DisplayScreen<T extends Displayable, V extends Display> {
    private T formView;
    private V display;

    public DisplayScreen(T formView, V display) {
        this.formView = formView;
        this.display = display;
    }

    public T getFormView() {
        return formView;
    }

    public V getDisplay() {
        return display;
    }
}
