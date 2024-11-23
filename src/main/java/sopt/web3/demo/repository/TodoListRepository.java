package sopt.web3.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sopt.web3.demo.entity.Member;
import sopt.web3.demo.entity.TodoList;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Long> {
    List<TodoList> findByMember(Member member);

    Optional<TodoList> findByMemberAndDate(Member member, LocalDate date);
}
