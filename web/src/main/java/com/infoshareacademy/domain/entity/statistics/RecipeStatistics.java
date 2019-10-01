package com.infoshareacademy.domain.entity.statistics;

import com.infoshareacademy.domain.entity.Category;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "statistics")
@NamedQueries({
        @NamedQuery(
                name = "Recipe.findTop10Recipies",
            query = "SELECT rs.recipieName, count (rs.recipieName) as quantity "
                + "FROM RecipeStatistics rs  WHERE rs.type =1 GROUP BY rs.recipieName "
                + "ORDER BY quantity DESC")})

public class RecipeStatistics {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private int type;

    @Column(name = "recipe_id")
    private Long recipieId;

    @Column(name = "recipie_name")
    private String recipieName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ElementCollection
    @Column(name = "categories")
    private Set<Long> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    public Long getRecipieId() {
        return recipieId;
    }

    public void setRecipieId(Long recipieId) {
        this.recipieId = recipieId;
    }

    public String getRecipieName() {
        return recipieName;
    }

    public void setRecipieName(String recipieName) {
        this.recipieName = recipieName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Long> getCategories() {
        return categories;
    }

    public void setCategories(Set<Long> categories) {
        this.categories = categories;
    }
}
