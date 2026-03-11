package io.hamza.recipemanagement.customer;

import jakarta.persistence.*;

import java.util.List;
import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateBirth;

    public Customer() {
    }

    public Customer(Long id, String name, String address, String dateBirth) {
        this.id = id;
        this.name = name;
        this.address = address;
        try {
            this.dateBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateBirth);
        }
        catch (Exception e) {
            //The handling for the code
        }
    }

    public Customer(String name,String address, String dateBirth) {
        this.name = name;
        this.address = address;
        try {
            this.dateBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateBirth);
        }
        catch (Exception e) {
            //The handling for the code
        }
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

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        try {
            this.dateBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateBirth);
        }
        catch (Exception e) {
            //The handling for the code
        }
    }
}
