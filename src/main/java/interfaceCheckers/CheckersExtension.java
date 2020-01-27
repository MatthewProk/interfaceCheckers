package interfaceCheckers;

@SuppressWarnings("unchecked")
public interface CheckersExtension<T> {

    default T self() {
        return (T) this;
    }
}
