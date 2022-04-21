package amcode.consolui.view.form.input;

public abstract class InputField<T> {
    private T value;

    public InputField(T value) {
        this.value = value;
    }

    public InputField() {
        this.value = null;
    }

    public boolean trySetValue(T value) {
        this.value = value;
        return true;
    }


    public T getValue() {
        return value;
    }


    protected abstract T tryParse(String value);

}