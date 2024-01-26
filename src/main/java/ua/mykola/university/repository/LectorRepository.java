package ua.mykola.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.mykola.university.entity.Lector;

/**
 * Repository to work with Lector entity
 */
@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {
}
