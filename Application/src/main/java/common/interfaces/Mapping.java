package common.interfaces;

/**
 * This interface is used to map entities and view models. This can also be used for DTOs.
 *
 * @param <T>
 * @param <V>
 */
public interface Mapping<T, V> {
    public V mapToEntity(T viewModel);
    public T mapToModel(V entity);

}
