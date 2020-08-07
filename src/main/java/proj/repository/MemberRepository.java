package proj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import proj.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findByUserId(String userId);

    @Query("SELECT m.userNo, m.userId, m.userPw, m.userName, m.coin, m.regDate "
            + "FROM Member m ")
    public List<Object[]> listAllMember();

}