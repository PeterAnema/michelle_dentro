package nl.novi.michelle_dentro.controller;

import nl.novi.michelle_dentro.service.MemberOnExamDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MemberOnExamDayController {

    @Autowired
    MemberOnExamDayService memberOnExamDayService;

    @PostMapping("/examdays/{examday_id}/member/{member_id}/coordinators")
    public ResponseEntity<Object> signUpCoordinator(@PathVariable("examday_id") Long examday_id,
                                                    @PathVariable("member_id") Long member_id,
                                                    @RequestBody Map<String, String> fields) {
        memberOnExamDayService.signUpExamDayCoordinator(examday_id, member_id, fields);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/examdays/{examday_id}/member/{member_id}/examinators")
    public ResponseEntity<Object> signUpExaminator(@PathVariable("examday_id") Long examday_id,
                                                   @PathVariable("member_id") Long member_id,
                                                   @RequestBody Map<String, String> fields) {
        memberOnExamDayService.signUpExamDayExaminator(examday_id, member_id, fields);
        return ResponseEntity.ok("OK");
    }

    @PostMapping("/examdays/{examday_id}/member/{member_id}/students")
    public ResponseEntity<Object> signUpStudent(@PathVariable("examday_id") Long examday_id,
                                                @PathVariable("member_id") Long member_id,
                                                @RequestBody Map<String, String> fields) {
        memberOnExamDayService.signUpExamDayStudent(examday_id, member_id, fields);
        return ResponseEntity.ok("OK");
    }

}
