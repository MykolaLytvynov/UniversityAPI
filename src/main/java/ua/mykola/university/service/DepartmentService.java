package ua.mykola.university.service;

import org.springframework.http.ResponseEntity;
import ua.mykola.university.entity.Department;
import ua.mykola.university.rest.response.StatisticsResponse;

import java.util.List;

/**
 * Department Service
 */
public interface DepartmentService {
    /**
     * Save department to the DB
     *
     * @param department - department
     * @return saved department
     */
    public Department save(Department department);

    /**
     * Return response with all departments from the DB
     *
     * @return response with departments from the DB
     */
    public ResponseEntity<List<Department>> findAll();

    /**
     * Return response with a count of assistants,
     * associate professors, and professors who work in this department
     * by department id
     *
     * @param departmentId - department id
     * @return response with statistics
     */
    public ResponseEntity<StatisticsResponse> getStatisticsByDepartmentId(long id);
}
