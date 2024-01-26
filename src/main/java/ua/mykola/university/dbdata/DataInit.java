package ua.mykola.university.dbdata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.mykola.university.entity.Degree;
import ua.mykola.university.entity.Department;
import ua.mykola.university.entity.Lector;
import ua.mykola.university.service.DepartmentService;
import ua.mykola.university.service.LectorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Random Data Generator for Database
 */
@Component
@RequiredArgsConstructor
public class DataInit implements CommandLineRunner {
    private Random rand = new Random();

    /** random names */
    private final String[] names = new String[]{"Poll", "Nika", "Christopher", "Mark",
            "Mykola", "Leo", "Maria", "Viktor", "Anastasiia", "Bobby"};

    /** random surnames */
    private final String[] surnames = new String[]{"Owen", "Fox", "Vargas", "Roberts", "Bohn", "Kohl", "Udisko",
            "Uno", "Korolo", "Schnallen", "Van"};

    private final Degree[] degrees = Degree.values();
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    @Override
    public void run(String... args) throws Exception {
        // saving random departments
        for (Department dep : getDepartments()) {
            departmentService.save(dep);
        }
    }

    /**
     * Get list of random departments
     *
     * @return list of random departments
     */
    private List<Department> getDepartments() {
        Department department1 = Department.builder()
                .name("Business")
                .lectors(getLectors(5))
                .build();
        Department department2 = Department.builder()
                .name("Polymer science")
                .lectors(getLectors(8))
                .build();
        Department department3 = Department.builder()
                .name("Engineering")
                .lectors(getLectors(2))
                .build();
        Department department4 = Department.builder()
                .name("Music")
                .lectors(getLectors(7))
                .build();
        return List.of(department1, department2, department3, department4);
    }

    /**
     * Get list of random saved Lectors
     *
     * @param countLectors - number of random lectors
     * @return random saved lectors
     */
    private List<Lector> getLectors(int countLectors) {
        List<Lector> lectors = new ArrayList<>();
        int maxLectors = countLectors;

        while (maxLectors >= 0) {
            String randomName = names[rand.nextInt(names.length)];
            String randomSurname = surnames[rand.nextInt(surnames.length)];
            Degree randomDegree = degrees[rand.nextInt(degrees.length)];

            lectors.add(Lector.builder()
                            .name(randomName)
                            .surname(randomSurname)
                            .degree(randomDegree)
                    .build());
            maxLectors--;
        }
        lectors.forEach(lector -> lectorService.save(lector));
        return lectors;
    }
}

