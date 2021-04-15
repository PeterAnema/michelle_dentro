package nl.novi.michelle_dentro.repository;

import nl.novi.michelle_dentro.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
