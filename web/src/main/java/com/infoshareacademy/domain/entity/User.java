package com.infoshareacademy.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "User.findUserByName",
                query = "SELECT u FROM User u WHERE u.name like :name"),
        @NamedQuery(
                name = "User.getUserList",
                query = "SELECT u FROM User u"),
        @NamedQuery(
                name = "User.getFavouritesList",
                query = "SELECT u.recipes FROM User u JOIN u.recipes r WHERE r.id=u.id"),
        @NamedQuery(
                name = "User.getFavouriteRecipeById",
                query = "SELECT r FROM User u JOIN u.recipes r WHERE r.id= :id"),
        @NamedQuery(
                name = "User.getFavouritesListIdsForUser",
                query = "SELECT r.id FROM Recipe r JOIN r.users u WHERE r.id=u.id AND u.id=:id"),
                //query = "SELECT r.recipe_id FROM User u JOIN u.recipes r WHERE r.id=u.id AND u.id=:id"),

        @NamedQuery(
                name = "User.getFavouriteRecipeByIdForUser",
                query = "SELECT r FROM User u JOIN u.recipes r WHERE r.id= :id AND u.id=:idu"),


})

@Entity
@Table(name = "user", indexes = {@Index(name = "user_name", columnList = "name")})
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "surname")
    @NotNull
    private String surname;

    @Column(name = "user_type")
    @NotNull
    private String userType;

    @Column(name = "login")
    @NotNull
    private String login;

    @Column(name = "password")
    @NotNull
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_favourite_recipe",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")})


    private List<Recipe> recipes = new ArrayList<>();

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}