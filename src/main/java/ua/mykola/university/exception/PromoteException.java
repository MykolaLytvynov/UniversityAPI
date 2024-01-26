package ua.mykola.university.exception;

/**
 *  Exception for impossible promotion of a lector
 */
public class PromoteException extends RuntimeException {
    public PromoteException(String message) {
        super(message);
    }
}
