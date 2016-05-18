package be.odisee.oxyplast.domain;

import javax.persistence.*;

import be.odisee.oxyplast.domain.User;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;


    // getters, setters

    public User(){
    	
    }
    public User(int id, String email, String password){
    	this.id = id;
    	this.email = email;
    	this.password = password;
    }

}