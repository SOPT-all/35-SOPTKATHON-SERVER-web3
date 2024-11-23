package sopt.web3.demo.entity;

import jakarta.persistence.*;
import sopt.web3.demo.entity.Member;
import java.time.LocalDate;

@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @Column
    private int level;

    @Column
    private int numCompleted;

    @Column
    private int numAll;

    @Column
    private boolean isSubmitted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    public TodoList(LocalDate date, int level, int numCompleted, int numAll, boolean isSubmitted, Member member) {
        this.date = date;
        this.level = level;
        this.numCompleted = numCompleted;
        this.numAll = numAll;
        this.isSubmitted = isSubmitted;
        this.member = member;
    }


    public TodoList() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getLocalDate() {
        return date;
    }

    public int getLevel() {
        return level;
    }

    public int getNumCompleted() {
        return numCompleted;
    }

    public int getNumAll() {
        return numAll;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public Member getMember() {
        return member;
    }
}