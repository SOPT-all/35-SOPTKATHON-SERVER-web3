package sopt.web3.demo.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class TodoListEntity {
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
    private MemberEntity member;

}