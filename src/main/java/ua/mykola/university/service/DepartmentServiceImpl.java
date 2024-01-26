package ua.mykola.university.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.mykola.university.entity.Department;
import ua.mykola.university.entity.Lector;
import ua.mykola.university.repository.DepartmentRepository;
import ua.mykola.university.rest.response.StatisticsResponse;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of DepartmentService
 */
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    /**
     * Save department to the DB
     *
     * @param department - department
     * @return saved department
     */
    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    /**
     * Return response with all departments from the DB
     *
     * @return response with departments from the DB
     */
    @Override
    public ResponseEntity<List<Department>> findAll() {
        List<Department> result = departmentRepository.findAll();
        return ResponseEntity.ok(result);
    }

    /**
     * Return response with a count of assistants,
     * associate professors, and professors who work in this department
     * by department id
     *
     * @param id - department id
     * @return response with statistics
     */
    @Override
    public ResponseEntity<StatisticsResponse> getStatisticsByDepartmentId(long id) {
        Optional<Department> department = departmentRepository.findById(id);

        if (department.isPresent()) {
            StatisticsResponse result = new StatisticsResponse();
            result.setDepartmentName(department.get().getName());

            for (Lector lector : department.get().getLectors()) {
                result.getDegreeToCount()
                        .merge(lector.getDegree(), 1, (prev, next) -> prev + next);
            }
            return ResponseEntity.ok(result);

        } else return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
