package nl.novi.michelle_dentro.controller;

import nl.novi.michelle_dentro.domain.Member;
import nl.novi.michelle_dentro.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<Object> getMembers() {
        return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Object> getMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PostMapping("/members")
    public ResponseEntity<Object> newMember(@RequestBody Map<String, String> fields) {
        return ResponseEntity.ok(memberService.newMember(fields));
    }

    @DeleteMapping("/members/{id}")
    public ResponseEntity<Object> deleteMemberById(@PathVariable Long id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

}
