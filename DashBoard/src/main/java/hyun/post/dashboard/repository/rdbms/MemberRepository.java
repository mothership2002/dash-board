package hyun.post.dashboard.repository.rdbms;

import hyun.post.dashboard.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m " +
            "from Member m " +
            "join fetch m.role r " +
            "where m.account = :account")
    Optional<Member> findMemberByAccount(@Param("account") String account);
}
