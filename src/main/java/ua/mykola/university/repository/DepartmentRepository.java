package ua.mykola.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.mykola.university.entity.Department;

/**
 * Repository to work with Department entity
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
