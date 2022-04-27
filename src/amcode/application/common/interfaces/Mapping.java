package amcode.application.common.interfaces;

public interface Mapping<T, V> {
    public V mapTo(T viewModel);
    public T mapFrom(V entity);

}
