package ua.mykola.university.entity;

import ua.mykola.university.exception.PromoteException;

/**
 * All possible degrees in the university
 */
public enum Degree {
    ASSISTANT(1),
    ASSOCIATE_PROFESSOR(2),
    PROFESSOR(3);

    private int value;

    Degree(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    /**
     * Promote degree or throw exception if lector has a professor's degree
     *
     * @return promoted Degree or PromoteException
     */
    public Degree promote() {
        switch (this) {
            case ASSISTANT -> {return ASSOCIATE_PROFESSOR;}
            case ASSOCIATE_PROFESSOR -> {return PROFESSOR;}
        };
        throw new PromoteException("It is impossible to promote. Lector is a professor");
    }
}
