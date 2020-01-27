package interfaceCheckers;

public interface LogIn<T> extends CheckersExtension<T> {

    default T logIn(){
        return self();
    }

}
