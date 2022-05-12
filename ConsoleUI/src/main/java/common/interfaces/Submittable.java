package common.interfaces;


import common.models.DisplayScreen;
import common.models.InputField;

import java.util.HashMap;

/**
 * This interface is used to submit data through the controller. After submitting data it will set the next view
 * which is returned by the controller.
 *
 * @param <T>
 */
public interface Submittable<T> {
    /**
     * After submitting data it will set the next view.
     * @param inputFields
     * @param controller
     * @return
     */
    DisplayScreen submit(HashMap<String, InputField> inputFields, Controller<T> controller);


}
