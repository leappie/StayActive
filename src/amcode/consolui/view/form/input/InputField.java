package amcode.consolui.view.form.input;

public abstract class InputField<T> {
    private T value;

    public InputField(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}