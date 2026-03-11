package io.hamza.recipemanagement.userLogin;

import jakarta.persistence.*;

import java.util.List;
import java.text.ParseException;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.security.NoSuchAlgorithmException;  
import java.security.MessageDigest; 

@Entity
public class UserLogin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String username;

    private String address;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date dateBirth;

    private String password;

    public UserLogin() {
    }

    public String funcEncryptedpassword(String password)
    {    
        try   
        {  
            /* MessageDigest instance for MD5. */  
            MessageDigest m = MessageDigest.getInstance("MD5");  
              
            /* Add plain-text password bytes to digest using MD5 update() method. */  
            m.update(password.getBytes());  
              
            /* Convert the hash value into bytes */   
            byte[] bytes = m.digest();  
              
            /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */  
            StringBuilder s = new StringBuilder();  
            for(int i=0; i< bytes.length ;i++)  
            {  
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));  
            }  
              
            /* Complete hashed password in hexadecimal format */  
            password = s.toString();  
        }   
        catch (NoSuchAlgorithmException e)   
        {  
            e.printStackTrace();  
        }  

        return password;

    }

    public UserLogin(Long id, String name, String username, String address, String dateBirth, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.address = address;
        this.password = funcEncryptedpassword(password);
        try {
            this.dateBirth = new SimpleDateFormat("dd/MM/yyyy").parse(dateBirth);
        }
        catch (Exception e) {
            //The handling for the code
        }
    }

    public UserLogin(String name, String username, String address, String dateBirth, String password) {
        this.name = name;
        this.username = username;
        this.address = address;
        this.password = funcEncryptedpassword(password);
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

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = funcEncryptedpassword(password);
    }
}
