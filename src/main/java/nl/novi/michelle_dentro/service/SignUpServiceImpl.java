package nl.novi.michelle_dentro.service;

import nl.novi.michelle_dentro.domain.ExamDay;
import nl.novi.michelle_dentro.domain.Member;
import nl.novi.michelle_dentro.repository.ExamDayRepository;
import nl.novi.michelle_dentro.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    ExamDayRepository examDayRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void signUpExamDayAsCoordinator(long examday_id, Map<String, String> fields) {
        long member_id = Long.parseLong(fields.get("member_id"));
        fields.remove("member_id");
        Optional<ExamDay> examDayOptional = examDayRepository.findById(examday_id);
        Optional<Member> memberOptional = memberRepository.findById(member_id);
        if (examDayOptional.isPresent() && memberOptional.isPresent()) {
            ExamDay examDay = examDayOptional.get();
            Member member = memberOptional.get();
            examDay.setCoordinator(member);
            member.setExamDayAsCoordinator(examDay);
            examDayRepository.save(examDay);
            memberRepository.save(member);
        }
    }

    @Override
    public void signUpExamDayAsExaminator(long examday_id, Map<String, String> fields) {
        long member_id = Long.parseLong(fields.get("member_id"));
        fields.remove("member_id");
        Optional<ExamDay> examDayOptional = examDayRepository.findById(examday_id);
        Optional<Member> memberOptional = memberRepository.findById(member_id);
        if (examDayOptional.isPresent() && memberOptional.isPresent()) {
            ExamDay examDay = examDayOptional.get();
            Member member = memberOptional.get();
            examDay.getExaminators().add(member);
            member.getExamDaysAsExaminator().add(examDay);
            examDayRepository.save(examDay);
            memberRepository.save(member);
        }
    }

    @Override
    public void signUpExamDayAsStudent(long examday_id, Map<String, String> fields) {
        long member_id = Long.parseLong(fields.get("member_id"));
        fields.remove("member_id");
        Optional<ExamDay> examDayOptional = examDayRepository.findById(examday_id);
        Optional<Member> memberOptional = memberRepository.findById(member_id);
        if (examDayOptional.isPresent() && memberOptional.isPresent()) {
            ExamDay examDay = examDayOptional.get();
            Member member = memberOptional.get();
            examDay.getStudents().add(member);
            member.getExamDaysAsStudent().add(examDay);
            examDayRepository.save(examDay);
            memberRepository.save(member);
        }
    }

}
