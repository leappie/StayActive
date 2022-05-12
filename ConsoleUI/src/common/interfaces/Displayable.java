package common.interfaces;

import common.enums.Display;

/**
 * The class that implements this interface is a view.
 */
public interface Displayable {
    /**
     * The enum display refers what screen you want to see.
     *
     * @param display
     */
    void display(Display display);
}
