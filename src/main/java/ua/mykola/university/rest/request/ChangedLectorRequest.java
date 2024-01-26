package ua.mykola.university.rest.request;

import lombok.Builder;
import lombok.Getter;

/**
 * Request from UI to update lector
 */
@Getter
@Builder
public class ChangedLectorRequest {
    /** Lector id */
    private long id;

    /** Changed name for saving to BD */
    private String changedName;

    /** Changed surname for saving to BD */
    private String changedSurname;
}
