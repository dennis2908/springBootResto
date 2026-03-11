package io.hamza.recipemanagement.branch;

import io.hamza.recipemanagement.resto.Resto;
import jakarta.persistence.*;

import java.util.List;
import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "branch")
    private List<Resto> restos;

    public Branch() {
    }

    public Branch(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Branch(String name) {
        this.name = name;
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


    public List<Resto> getRestos() {
        return restos;
    }

    public void setRestos(List<Resto> restos) {
        this.restos = restos;
    }
}
