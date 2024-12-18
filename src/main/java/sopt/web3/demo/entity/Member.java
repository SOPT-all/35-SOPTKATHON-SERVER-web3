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

    public Member(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void increaseLevel(){
        this.level += 1;
    }

    public void decreaseLevel(){
        this.level -= 1;
    }
}
