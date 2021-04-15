package nl.novi.michelle_dentro.service;

import nl.novi.michelle_dentro.domain.ExamDay;
import nl.novi.michelle_dentro.repository.ExamDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExamDayServiceImpl implements ExamDayService {

    @Autowired
    ExamDayRepository examDayRepository;

    @Override
    public List<ExamDay> getExamDays() {
        return examDayRepository.findAll();
    }

    @Override
    public Optional<ExamDay> getExamDayById(long id) {
        return examDayRepository.findById(id);
    }

    @Override
    public Long newExamDay(Map<String, String> fields) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(fields.get("date"), formatter);
        ExamDay newExamDay = new ExamDay();
        newExamDay.setDate(dateTime);
        ExamDay storedExamDay =  examDayRepository.save(newExamDay);
        return storedExamDay.getId();
    }

    @Override
    public void deleteExamDayById(long id) {
        examDayRepository.deleteById(id);
    }

}
