package com.infoshareacademy.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipes")
public class Recipe {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "instruction")
    @NotNull
    private String instruction;

    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "drinkType")
    @NotNull
    private String drinkType;

    @Column(name = "glassType")
    @NotNull
    private String glassType;

    @Column(name = "modificationDate")
    @NotNull
    private String modificationDate;

    @ManyToMany
    @JoinTable(
            name = "ingredients_users",
            joinColumns = { @JoinColumn(name = "recipe_id") },
            inverseJoinColumns = { @JoinColumn(name = "ingredient_id") }
    )
    private List<Ingredient> ingredients = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}


