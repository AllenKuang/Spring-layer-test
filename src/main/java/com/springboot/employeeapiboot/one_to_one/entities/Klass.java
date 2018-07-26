package com.springboot.employeeapiboot.one_to_one.entities;

import javax.persistence.*;

@Entity
public class Klass {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "klass",fetch=FetchType.LAZY)
    private Leader leader=new Leader();
    public Long getId() {
        return id;
    }

    public Klass(String name) {
        this.name = name;
    }
    public Klass(){

    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }
}
