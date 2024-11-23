package sopt.web3.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.web3.demo.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
