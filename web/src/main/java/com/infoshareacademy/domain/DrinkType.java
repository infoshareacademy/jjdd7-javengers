package com.infoshareacademy.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drink_type")
public class DrinkType {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", unique = true, length = 50) //TODO change to enum
  @NotNull
  private String name;

  @OneToMany(mappedBy = "drinkType")
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

  public List<Recipe> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<Recipe> recipes) {
    this.recipes = recipes;
  }
}
