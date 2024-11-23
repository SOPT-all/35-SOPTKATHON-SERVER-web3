package sopt.web3.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate date;

    @Column
    private Integer level;

    @Column
    private Integer numCompleted;

    @Column
    private Integer numAll;

    @Column
    private boolean isSubmitted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void setSubmitted(boolean submitted) {
        isSubmitted = submitted;
    }

    public TodoList(LocalDate date, Integer level, Integer numCompleted, Integer numAll, boolean isSubmitted, Member member) {
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

    public Integer getLevel() {
        return level;
    }

    public Integer getNumCompleted() {
        return numCompleted;
    }

    public Integer getNumAll() {
        return numAll;
    }

    public void setNumCompleted(Integer numCompleted) {
        this.numCompleted = numCompleted;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public Member getMember() {
        return member;
    }

    public void increaseNumAll(int num){
        this.numAll += num;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public void decreaseNumAll(int num){
        this.numAll -= num;
    }
}