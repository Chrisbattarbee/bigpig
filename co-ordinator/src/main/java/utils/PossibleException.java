package utils;

import com.sun.istack.internal.NotNull;

public class PossibleException<T extends Exception> {
    private final T exception;

    public PossibleException(T exception) {
        this.exception = exception;
    }

    public boolean hasException() {
        return exception != null;
    }

    public T getException() {
        return exception;
    }

    public void throwIfException() throws T {
        if(hasException() && exception != null) {
            throw exception;
        }
    }

}
