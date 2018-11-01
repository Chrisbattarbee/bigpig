package utils;

import java.io.Serializable;

public class PossibleException<T extends Exception> implements Serializable {
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
        if(hasException()) {
            throw exception;
        }
    }

}
