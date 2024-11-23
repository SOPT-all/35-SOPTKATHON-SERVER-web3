package sopt.web3.demo.entity;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private int level;

}
