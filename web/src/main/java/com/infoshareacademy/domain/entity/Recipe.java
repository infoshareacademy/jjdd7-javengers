package com.infoshareacademy.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe")
@NamedQueries({
        @NamedQuery(
                name = "Recipe.getRecipiesList",
                query = "SELECT r FROM Recipe r WHERE r.isApproved = true"),
        @NamedQuery(
                name = "Recipe.getFavouritesListById",
                query = "SELECT r FROM Recipe r WHERE r.id IN :favourites AND r.isApproved = true"),
        @NamedQuery(
                name = "Recipe.findRecipeByCategory",
                query = "SELECT r FROM Recipe r  WHERE r.category IN :categories AND r.isApproved = true ORDER BY r.name ASC"),
        @NamedQuery(
                name = "Recipe.findRecipeByCategoryAndIngredientAndTypeAndFavourites",
                query = "SELECT r FROM Recipe r  JOIN r.ingredients i JOIN r.users u WHERE  u.id=:id AND r.category IN :categories AND r.drinkType IN :drinkTypes AND (i.name IN :ingredients) AND r.isApproved = true GROUP BY r HAVING COUNT(DISTINCT i.name)=:namesLength ORDER BY r.name ASC "),
        @NamedQuery(
                name = "Recipe.findRecipeByCategoryIdAndIngredientNameAndType",
                query = "SELECT r FROM Recipe r  JOIN r.ingredients i WHERE r.category IN :categories  AND r.drinkType IN :drinkTypes AND (i.name IN :ingredients) GROUP BY r HAVING COUNT(DISTINCT i.name)=:namesLength AND r.isApproved = true ORDER BY r.name ASC "),
        @NamedQuery(
                name = "Recipe.findRecipeByLiveSearch",
                query = "SELECT r FROM Recipe as r WHERE r.name LIKE :nameChars AND r.isApproved = true"),
        @NamedQuery(
                name = "Recipe.getRecipeTypes",
                query = "Select distinct r.drinkType from Recipe r"),
        @NamedQuery(
                name = "Type.findTypeByName",
                query = "SELECT distinct r.drinkType FROM Recipe r WHERE r.drinkType in :types"),
        @NamedQuery(
                name = "Recipe.findRecipeByCategoryIdAndType",
                query = "SELECT r FROM Recipe r  WHERE r.category IN :categories AND r.drinkType IN :drinkTypes AND r.isApproved = true ORDER BY r.name ASC"),
        @NamedQuery(
                name = "Recipe.findRecipeByCategoryIdAndTypeAndFavourites",
                query = "SELECT r FROM Recipe r JOIN r.users u WHERE u.id=:id AND r.category IN :categories AND r.drinkType IN :drinkTypes AND r.isApproved = true ORDER BY r.name ASC"),
        @NamedQuery(
                name = "Recipe.getFavouritesListIdsForUser",
                query = "SELECT r.id FROM Recipe r JOIN r.users u WHERE  u.id=:id AND r.isApproved = true"),
        @NamedQuery(
                name = "Recipe.getFavouriteRecipeForUser",
                query = "SELECT r FROM Recipe r JOIN r.users u WHERE  u.id=:id AND r.id=:recipeId AND r.isApproved = true "),
        @NamedQuery(
                name = "Recipe.getTheBiggestId",
                query = "SELECT max(r.id) FROM Recipe r"),
        @NamedQuery(
                name = "Recipe.getUnauthorizedRecipes",
                query = "SELECT r FROM Recipe r WHERE r.isApproved = false"),
        @NamedQuery(
                name = "Recipe.getRecipiePerCategoryRank",
                query = "SELECT c.name, count (r.name) as quantity  FROM Recipe r JOIN r.category c group by c.id order by quantity DESC")

})

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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
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