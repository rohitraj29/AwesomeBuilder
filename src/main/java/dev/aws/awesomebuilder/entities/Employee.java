package dev.aws.awesomebuilder.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="T_EMP")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;
    @Column(name="NAME")
    @NotEmpty(message = "Please Enter Name")
    private String name;
    @Column(name="DESIG")
    @NotEmpty(message = "Please Enter Designation")
    private String designation;
    @Column(name="ADDR")
    @NotEmpty(message = "Please Enter Address")
    private String address;

    public Long getId() {
        return id;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
