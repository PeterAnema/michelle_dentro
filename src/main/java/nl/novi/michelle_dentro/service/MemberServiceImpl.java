package nl.novi.michelle_dentro.service;

import nl.novi.michelle_dentro.domain.Member;
import nl.novi.michelle_dentro.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> getMemberById(long id) {
        return memberRepository.findById(id);
    }

    @Override
    public Long newMember(Map<String, String> fields) {
        Member newMember = new Member();
        newMember.setName(fields.get("name"));
        Member storedMember =  memberRepository.save(newMember);
        return storedMember.getId();
    }

    @Override
    public void deleteMemberById(long id) {
        memberRepository.deleteById(id);
    }

}
