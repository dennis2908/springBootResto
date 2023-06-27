package io.hamza.recipemanagement.resto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.hamza.recipemanagement.branch.Branch;
import jakarta.persistence.*;

@Entity
public class Resto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;
    private String address;

    @ManyToOne
    @JsonBackReference
    private Branch branch;
    //private Customer customer;

    public Resto() {
    }

    public Resto(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Resto(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

}

