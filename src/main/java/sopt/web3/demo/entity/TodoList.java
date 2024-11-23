package sopt.web3.demo.entity;

import jakarta.persistence.*;
import sopt.web3.demo.domain.Member;

import java.sql.Date;

@Entity
public class TodoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @Column
    private int level;

    @Column
    private int num_completed;

    @Column
    private int num_all;

    @Column
    private boolean isSubmitted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private sopt.web3.demo.domain.Member member;

    public TodoList(Date date, int level, int num_completed, int num_all, boolean isSubmitted, Member member) {
        this.date = date;
        this.level = level;
        this.num_completed = num_completed;
        this.num_all = num_all;
        this.isSubmitted = isSubmitted;
        this.member = member;
    }


    public TodoList() {
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getLevel() {
        return level;
    }

    public int getNum_completed() {
        return num_completed;
    }

    public int getNum_all() {
        return num_all;
    }

    public boolean isSubmitted() {
        return isSubmitted;
    }

    public Member getMember() {
        return member;
    }
}