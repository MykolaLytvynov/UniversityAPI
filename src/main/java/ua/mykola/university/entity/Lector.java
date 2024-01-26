package ua.mykola.university.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * Lector entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Lector {
    /** Lector id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /** Lector name */
    private String name;

    /** Lector surname */
    private String surname;

    /** Lector degree */
    private Degree degree;
}
