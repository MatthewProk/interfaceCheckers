package interfaceCheckers;

public interface LogOut<T> extends CheckersExtension<T> {

    default T logOut(){
        return self();
    }
}
