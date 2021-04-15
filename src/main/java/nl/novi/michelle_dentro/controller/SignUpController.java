package nl.novi.michelle_dentro.controller;

import nl.novi.michelle_dentro.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @PostMapping("/examdays/{examday_id}/coordinator")
    public ResponseEntity<Object> signUpAsCoordinator(@PathVariable("examday_id") Long examday_id,
                                                      @RequestBody Map<String, String> fields) {
        signUpService.signUpExamDayAsCoordinator(examday_id, fields);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/examdays/{examday_id}/examinators")
    public ResponseEntity<Object> signUpAsExaminator(@PathVariable("examday_id") Long examday_id,
                                                     @RequestBody Map<String, String> fields) {
        signUpService.signUpExamDayAsExaminator(examday_id, fields);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/examdays/{examday_id}/students")
    public ResponseEntity<Object> signUpAsStudent(@PathVariable("examday_id") Long examday_id,
                                                  @RequestBody Map<String, String> fields) {
        signUpService.signUpExamDayAsStudent(examday_id, fields);
        return ResponseEntity.ok("OK");
    }


}
