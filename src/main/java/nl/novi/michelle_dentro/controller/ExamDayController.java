package nl.novi.michelle_dentro.controller;

import nl.novi.michelle_dentro.domain.ExamDay;
import nl.novi.michelle_dentro.service.ExamDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ExamDayController {

    @Autowired
    ExamDayService examDayService;

    @GetMapping("/examdays")
    public ResponseEntity<Object> getExamDays() {
        return ResponseEntity.ok(examDayService.getExamDays());
    }

    @GetMapping("/examdays/{id}")
    public ResponseEntity<Object> getExamDayById(@PathVariable Long id) {
        return ResponseEntity.ok(examDayService.getExamDayById(id));
    }

    @PostMapping("/examdays")
    public ResponseEntity<Object> newExamDay(@RequestBody Map<String, String> fields) {
        return ResponseEntity.ok(examDayService.newExamDay(fields));
    }

    @DeleteMapping("/examdays/{id}")
    public ResponseEntity<Object> deleteExamDayById(@PathVariable Long id) {
        return ResponseEntity.ok(examDayService.getExamDayById(id));
    }

}
