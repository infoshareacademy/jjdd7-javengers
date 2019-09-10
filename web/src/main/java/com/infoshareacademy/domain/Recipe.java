package com.infoshareacademy.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe")
public class Recipe {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", unique = true, length = 100)
  @NotNull
  private String name;

  @Column(name = "is_custom")
  @NotNull
  private Boolean isCustom;

  @Column(name = "is_approved")
  @NotNull
  private Boolean isApproved;

  @Column(name = "instruction", length = 1000)
  @NotNull
  private String instruction;

  @Column
  @NotNull
  private String drinkType;

  @Column(name = "glass_type")
  @NotNull
  private String glassType;

  @Column(name = "modification_date")
  @NotNull
  private String modificationDate;

  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  @Column(name = "image_url_address", length = 1000)
  @NotNull
  private String imageUrlAddress;

  @ManyToMany
  @JoinTable(
      name = "recipe_to_ingredient",
      joinColumns = {@JoinColumn(name = "recipe_id", referencedColumnName = "id")},
      inverseJoinColumns = {@JoinColumn(name = "ingredient_id", referencedColumnName = "id")})
  private List<Ingredient> ingredients = new ArrayList<>();

  @ManyToMany(mappedBy = "recipes")
  private List<User> users = new ArrayList<>();

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

  public Boolean getCustom() {
    return isCustom;
  }

  public void setCustom(Boolean custom) {
    isCustom = custom;
  }

  public Boolean getApproved() {
    return isApproved;
  }

  public void setApproved(Boolean approved) {
    isApproved = approved;
  }

  public String getInstruction() {
    return instruction;
  }

  public void setInstruction(String instruction) {
    this.instruction = instruction;
  }

  public String  getDrinkType() {
    return drinkType;
  }

  public void setDrinkType(String drinkType) {
    this.drinkType = drinkType;
  }

  public String getGlassType() {
    return glassType;
  }

  public void setGlassType(String glassType) {
    this.glassType = glassType;
  }

  public String getModificationDate() {
    return modificationDate;
  }

  public void setModificationDate(String modificationDate) {
    this.modificationDate = modificationDate;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public String getImageUrlAddress() {
    return imageUrlAddress;
  }

  public void setImageUrlAddress(String imageUrlAddress) {
    this.imageUrlAddress = imageUrlAddress;
  }

  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }


}


