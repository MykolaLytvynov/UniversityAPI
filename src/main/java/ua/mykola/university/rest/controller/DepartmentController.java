package ua.mykola.university.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import ua.mykola.university.entity.Department;
import ua.mykola.university.rest.response.StatisticsResponse;
import ua.mykola.university.service.DepartmentService;

import java.util.List;

/**
 * Controller of departments
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    /** Url of the UI website */
    private final String crossOrigin = "http://localhost:3000";

    /**
     * Return response with all departments from the DB
     *
     * @return response with departments from the DB
     */
    @GetMapping()
    @CrossOrigin(origins = crossOrigin)
    public ResponseEntity<List<Department>> getAll(){
        return departmentService.findAll();
    }

    /**
     * Return response with a count of assistants,
     * associate professors, and professors who work in this department
     * by department id
     *
     * @param departmentId - department id
     * @return response with statistics
     */
    @GetMapping("/{department_id}/statistics")
    @CrossOrigin(origins = crossOrigin)
    public ResponseEntity<StatisticsResponse> getStatistics(@PathVariable("department_id") long departmentId){
        return departmentService.getStatisticsByDepartmentId(departmentId);
    }
}
