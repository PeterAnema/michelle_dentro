package nl.novi.michelle_dentro.service;

import nl.novi.michelle_dentro.domain.Member;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemberService {

    List<Member> getMembers();
    Optional<Member> getMemberById(long id);
    Long newMember(Map<String, String> fields);
    void deleteMemberById(long id);

}
