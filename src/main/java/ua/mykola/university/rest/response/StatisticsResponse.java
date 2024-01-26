package ua.mykola.university.rest.response;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import ua.mykola.university.entity.Degree;

import java.util.HashMap;
import java.util.Map;

/**
 * Response for UI with a count of assistants, associate professors,
 * and professors who work in this department.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatisticsResponse {
    /** department name */
    private String departmentName;

    /**
     * statistics of working lectors
     * key is degree
     * value is number of working lectors having this degree
     */
    private Map<Degree, Integer> degreeToCount = new HashMap<>();

    {
        degreeToCount.put(Degree.ASSISTANT, 0);
        degreeToCount.put(Degree.ASSOCIATE_PROFESSOR, 0);
        degreeToCount.put(Degree.PROFESSOR, 0);
    }

}
