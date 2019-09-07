package com.infoshareacademy.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ingredient")
public class Ingredient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, length = 100)
    @NotNull
    private String name;

    @ManyToMany
    @JoinTable(
        name = "ingredient_to_measure",
        joinColumns = {@JoinColumn(name = "ingredient_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "measure_id", referencedColumnName = "id")})
    private List<MeasureOfIngredient> measures = new ArrayList<>();

    @ManyToMany(mappedBy = "ingredients")
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


    public List<MeasureOfIngredient> getMeasures() {
        return measures;
    }

    public void setMeasures(List<MeasureOfIngredient> measures) {
        this.measures = measures;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
