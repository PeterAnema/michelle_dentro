package nl.novi.michelle_dentro.service;

import nl.novi.michelle_dentro.domain.ExamDay;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ExamDayService {

    List<ExamDay> getExamDays();
    Optional<ExamDay> getExamDayById(long id);
    Long newExamDay(Map<String, String> fields);
    void deleteExamDayById(long id);

}
