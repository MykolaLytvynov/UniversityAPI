package ua.mykola.university.service;

import org.springframework.http.ResponseEntity;
import ua.mykola.university.entity.Lector;
import ua.mykola.university.rest.request.ChangedLectorRequest;

import java.util.List;

/**
 * Lector Service
 */
public interface LectorService {

    /**
     * save lector to the DB
     *
     * @param lector - lector
     * @return saved lector
     */
    Lector save(Lector lector);

    /**
     * Return response with found lector from the DB
     *
     * @param id - lector id
     * @return response with found lector
     */
    ResponseEntity<Lector> getById(long id);

    /**
     * Promote lector if it's possible and return promoted lector
     * or return response with 400 status code
     *
     * @param id - lector id
     * @return response with promoted lector or with 400 status code
     */
    ResponseEntity<Lector> promote(long id);

    /**
     * Return response with all lectors from the DB
     *
     * @return response with all lectors
     */
    ResponseEntity<List<Lector>> findAll();

    /**
     * Update name and surname and return response with updated lector
     *
     * @param changedLector - request with lector id, changed name and changed surname
     * @return response with updated lector
     */
    ResponseEntity<Lector> update(ChangedLectorRequest changedLector);
}
