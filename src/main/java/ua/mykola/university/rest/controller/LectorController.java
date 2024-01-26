package ua.mykola.university.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import ua.mykola.university.entity.Lector;
import ua.mykola.university.rest.request.ChangedLectorRequest;
import ua.mykola.university.service.LectorService;

import java.util.List;

/**
 * Controller of lectors
 */
@RestController
@RequestMapping("/lector")
@RequiredArgsConstructor
public class LectorController {
    private final LectorService lectorService;

    /** Url of the UI website */
    private final String crossOrigin = "http://localhost:3000";

    /**
     * Return response with found lector from the DB
     *
     * @param lectorId - lector id
     * @return response with found lector
     */
    @GetMapping("/{lector_id}")
    @CrossOrigin(origins = crossOrigin)
    public ResponseEntity<Lector> getById(@PathVariable("lector_id") long lectorId) {
        return lectorService.getById(lectorId);
    }

    /**
     * Return response with all lectors from the DB
     *
     * @return response with all lectors
     */
    @GetMapping()
    @CrossOrigin(origins = crossOrigin)
    public ResponseEntity<List<Lector>> getAll(){
        return lectorService.findAll();
    }

    /**
     * Promote lector if it's possible and return promoted lector
     * or return response with 400 status code
     *
     * @param lectorId - lector id
     * @return response with promoted lector or with 400 status code
     */
    @PutMapping("/{lector_id}/promote")
    @CrossOrigin(origins = crossOrigin)
    public ResponseEntity<Lector> promote(@PathVariable("lector_id") long lectorId) {
        return lectorService.promote(lectorId);
    }

    /**
     * update name and surname and return response with updated lector
     *
     * @param changedLector - request with lector id, changed name and changed surname
     * @return response with updated lector
     */
    @PostMapping("/update")
    @CrossOrigin(origins = crossOrigin)
    public ResponseEntity<Lector> update(@RequestBody ChangedLectorRequest changedLector) {
        return lectorService.update(changedLector);
    }
}
