package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    @OneToMany(mappedBy="player", fetch=FetchType.EAGER)
    private Set<GamePlayer> gamePlayers = new HashSet<>();

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;



    public Player() {}

        public Player(String first, String last, String userName, String email, String password) {
            this.firstName = first;
            this.lastName = last;
            this.userName = userName;
            this.email = email;
            this.password = password;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName(){ return this.lastName;  }

        public String getUserName() { return userName; }

        public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

        public void setLastName(String lastName) { this.lastName = lastName; }

        public void setUserName(String userName) { this.userName = userName;}

        public void setEmail(String email) { this.email = email; }

        public void setPassword (String password) { this.password = password;}

        public Long getId() { return this.id;}

        public String getEmail() { return this.email;}



    public String toString() {
            return firstName + " " + lastName;
        }

}

