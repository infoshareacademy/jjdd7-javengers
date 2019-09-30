package com.infoshareacademy.domain.entity;

import com.infoshareacademy.domain.entity.statistics.RecipeStatistics;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(
        name = "Category.findCategoryByName",
        query = "SELECT c FROM Category c WHERE c.name like :name"),

     @NamedQuery(
                name = "Category.findCategoryById",
                query = "SELECT c FROM Category c WHERE c.id in :ids"),
    @NamedQuery(
        name = "Category.getCategoryList",
        query = "SELECT c FROM Category c"),

        @NamedQuery(
                name = "Category.getCategoryIds",
                query = "SELECT c.id FROM Category c")

})

@Entity
@Table(name = "category", indexes = {@Index(name = "category_name", columnList = "name")})
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, length = 50)
    @NotNull
    private String name;

    @OneToOne(mappedBy = "category")
    private RecipeStatistics recipeStatistics;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
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

    public RecipeStatistics getRecipeStatistics() {
        return recipeStatistics;
    }

    public void setRecipeStatistics(RecipeStatistics recipeStatistics) {
        this.recipeStatistics = recipeStatistics;
    }
}