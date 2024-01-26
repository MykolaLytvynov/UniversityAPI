package ua.mykola.university.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.mykola.university.entity.Lector;
import ua.mykola.university.exception.PromoteException;
import ua.mykola.university.repository.LectorRepository;
import ua.mykola.university.rest.request.ChangedLectorRequest;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of LectorService
 */
@Service
@RequiredArgsConstructor
public class LectorServiceImpl implements LectorService{
    private final LectorRepository lectorRepository;

    /**
     * Save lector to the DB
     *
     * @param lector - lector
     * @return saved lector
     */
    @Override
    public Lector save(Lector lector) {
        return lectorRepository.save(lector);
    }

    /**
     * Return response with found lector from the DB
     *
     * @param id - lector id
     * @return response with found lector
     */
    @Override
    public ResponseEntity<Lector> getById(long id) {
        Optional<Lector> lector = lectorRepository.findById(id);
        if (lector.isPresent()) {
            return ResponseEntity.ok(lector.get());
        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    /**
     * Promote lector if it's possible and return promoted lector
     * or return response with 400 status code
     *
     * @param id - lector id
     * @return response with promoted lector or with 400 status code
     */
    @Override
    public ResponseEntity<Lector> promote(long id) {
        Optional<Lector> optionalLector = lectorRepository.findById(id);
        if (optionalLector.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Lector foundLector = optionalLector.get();
        try {
            foundLector.setDegree(foundLector.getDegree().promote());
            lectorRepository.save(foundLector);
        } catch (PromoteException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.ok(foundLector);
    }

    /**
     * Return response with all lectors from the DB
     *
     * @return response with all lectors
     */
    @Override
    public ResponseEntity<List<Lector>> findAll() {
        return ResponseEntity.ok(lectorRepository.findAll());
    }

    /**
     * Update name and surname and return response with updated lector
     *
     * @param changedLector - request with lector id, changed name and changed surname
     * @return response with updated lector
     */
    @Override
    public ResponseEntity<Lector> update(ChangedLectorRequest changedLector) {
        Optional<Lector> optionalLector = lectorRepository.findById(changedLector.getId());
        if (optionalLector.isEmpty()) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Lector foundLector = optionalLector.get();
        foundLector.setName(changedLector.getChangedName());
        foundLector.setSurname(changedLector.getChangedSurname());

        lectorRepository.save(foundLector);
        return ResponseEntity.ok(foundLector);
    }
}
