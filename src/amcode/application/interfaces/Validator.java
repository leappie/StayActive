package amcode.application.interfaces;

public interface Validator<T> {
    String invalidValueMessage();
    boolean isValid(T value);
}
