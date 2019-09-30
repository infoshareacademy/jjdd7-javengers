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


    @NamedQuery(
        name = "User.findUserByEmail",
        query = "SELECT u FROM User u WHERE u.email like :email"),
    @NamedQuery(
        name = "User.getUsersList",
        query = "SELECT u FROM User u")
})

@Entity
@Table(name = "user", indexes = {@Index(name = "user_email", columnList = "email")})
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "email")
    @NotNull
    private String email;

    @Column(name = "user_type")
    @NotNull
    private String userType;


    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}