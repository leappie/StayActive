package amcode.application.common.interfaces;

public interface Validator<T> {
    String invalidValueMessage();
    boolean isValid(T value);
}
