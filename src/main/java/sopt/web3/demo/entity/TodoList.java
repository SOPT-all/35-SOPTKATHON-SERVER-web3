package sopt.web3.demo.entity;

import jakarta.persistence.*;

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
    private int numCompleted;

    @Column
    private int numAll;

    @Column
    private boolean isSubmitted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Long getId() {
        return id;
    }
    public Date getDate() {
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
    public boolean getIsSubmitted() {
        return isSubmitted;
    }
}