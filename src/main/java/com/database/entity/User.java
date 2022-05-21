package com.database.entity;

import com.database.entity.dto.UserLoginDto;
import com.database.entity.dto.UserRegisterDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * User Entity for user table
 */

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
@ApiModel(value = "User Api model documentation", description = "Model")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(value = "Unique id field of user object")
    private int id; //Unique id value for user

    @ApiModelProperty(value = "Unique name field of user object")
    private String name;

    @ApiModelProperty(value = "Email address field of the user")
    @JsonIgnore
    private String email;

    @ApiModelProperty(value = "Password field of the user")
    @JsonIgnore
    private String password;

    @JsonIgnore
    private String role;

    public User(String name , String password , String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = "User";
    }

    public User(String name , String password) {
        this.name = name;
        this.password = password;
    }
    public User(int id){
        this.id = id;
    }

    public static User from(UserLoginDto userDto){
        String name = userDto.getName();
        String password = userDto.getPassword();
        return new User(name , password);
    }
    public static User from(UserRegisterDto userDto){
        String name = userDto.getName();
        String password = userDto.getPassword();
        String email = userDto.getEmail();
        return new User(name , password , email);
    }

}