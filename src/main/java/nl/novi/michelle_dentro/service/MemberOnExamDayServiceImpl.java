package nl.novi.michelle_dentro.service;

import nl.novi.michelle_dentro.domain.ExamDay;
import nl.novi.michelle_dentro.domain.Member;
import nl.novi.michelle_dentro.repository.ExamDayRepository;
import nl.novi.michelle_dentro.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberOnExamDayServiceImpl implements MemberOnExamDayService {

    @Autowired
    ExamDayRepository examDayRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void signUpExamDayCoordinator(long examday_id, long member_id, Map<String, String> fields) {
        Optional<ExamDay> examDayOptional = examDayRepository.findById(examday_id);
        Optional<Member> memberOptional = memberRepository.findById(member_id);
        if (examDayOptional.isPresent() && memberOptional.isPresent()) {
            ExamDay examDay = examDayOptional.get();
            Member member = memberOptional.get();
            examDay.getCoordinator().add(member);
            examDayRepository.save(examDay);
        }
    }

    @Override
    public void signUpExamDayExaminator(long examday_id, long member_id, Map<String, String> fields) {
        Optional<ExamDay> examDayOptional = examDayRepository.findById(examday_id);
        Optional<Member> memberOptional = memberRepository.findById(member_id);
        if (examDayOptional.isPresent() && memberOptional.isPresent()) {
            ExamDay examDay = examDayOptional.get();
            Member member = memberOptional.get();
            examDay.getExaminators().add(member);
            examDayRepository.save(examDay);
        }
    }

    @Override
    public void signUpExamDayStudent(long examday_id, long member_id, Map<String, String> fields) {
        Optional<ExamDay> examDayOptional = examDayRepository.findById(examday_id);
        Optional<Member> memberOptional = memberRepository.findById(member_id);
        if (examDayOptional.isPresent() && memberOptional.isPresent()) {
            ExamDay examDay = examDayOptional.get();
            Member member = memberOptional.get();
            examDay.getStudents().add(member);
            examDayRepository.save(examDay);
        }
    }
}
