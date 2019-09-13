package com.infoshareacademy.domain.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "recipe")
public class Recipe {

  @Id
  @Column(name = "id")
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

  @Column(name = "instruction", length = 10000)
  @NotNull
  private String instruction;

  @Column(name = "drink_type")
  @NotNull
  private String drinkType;

  @Column(name = "glass_type")
  @NotNull
  private String glassType;

  @Column(name = "modification_date")
  @NotNull
  private String modificationDate;

  @Column(name = "image_url", length = 1000)
  @NotNull
  private String imageUrl;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "category_id")
  private Category category;

  @ManyToMany(cascade = CascadeType.ALL)
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

  public String getDrinkType() {
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

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
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
