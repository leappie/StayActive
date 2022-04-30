package common.interfaces;


import common.models.DisplayScreen;
import common.models.InputField;

import java.util.HashMap;

/**
 * The controller is used by the UI to pass data from the view.
 *
 * @param <T>
 */
public interface Controller<T> {
    /**
     * Once data has been received. This will return a display screen. This will set the next view.
     *
     * @param inputField the input fields like int and string
     * @param model the view model
     * @return DisplayScreen
     */
    DisplayScreen execute(HashMap<String, InputField> inputField, T model);

}
