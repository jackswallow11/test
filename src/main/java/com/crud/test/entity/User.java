package com.crud.test.entity;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    @GeneratedValue
    @Id
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String password;



    @OneToOne
    @JoinColumn(name = "profile_id")
    public ImageFile userProfilePic;

    public User(){
    }

    public User( String email, String firstName, String lastName, String password, ImageFile userProfilePic) {
        super();
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userProfilePic = userProfilePic;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ImageFile getUserProfilePic() {
        return userProfilePic;
    }

    public void setUserProfilePic(ImageFile userProfilePic) {
        this.userProfilePic = userProfilePic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }
}
