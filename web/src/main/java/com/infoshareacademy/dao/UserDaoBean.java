package com.infoshareacademy.dao;

import com.infoshareacademy.domain.entity.Recipe;
import com.infoshareacademy.domain.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class UserDaoBean {

    @PersistenceContext
    EntityManager entityManager;

    public void save(User user) {
        entityManager.persist(user);
    }

    public User updateUser(User user) {
        return entityManager.merge(user);
    }

    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    public void deleteUserById(Long id) {
        User user = getUserById(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public User findUserByEmail(String email) {
        Query query = entityManager.createNamedQuery("User.findUserByEmail");
        query.setParameter("email", email);
        return (User) query.getResultList().stream().findFirst().orElse(null);
    }

    public List<User> getUsersList() {
        Query query = entityManager.createNamedQuery("User.getUsersList");
        return query.getResultList();
    }


    public User findUserByName(String name) {
        Query query = entityManager.createNamedQuery("User.findUserByName");
        query.setParameter("name", name);
        return (User) query.getResultList().stream().findFirst().orElse(null);
    }

    public List<Recipe> getFavouritesList() {
        Query query = entityManager.createNamedQuery("User.getFavouritesList");
        return query.getResultList();
    }

    public Recipe getFavouriteRecipeByIdForUser(Long favouriteId, Long userId) {
        Query query = entityManager.createNamedQuery("User.getFavouriteRecipeByIdForUser");
        query.setParameter("id", favouriteId);
        query.setParameter("idu", userId);
        return (Recipe) query.getSingleResult();
    }

    public List<Long> getFavouritesListIds(Long userId) {
        Query query = entityManager.createNamedQuery("User.getFavouritesListIdsForUser");
        query.setParameter("id", userId);
        return query.getResultList();
    }

    public void editFavouritesByIdForUSer(Long recipeId, Long userId) {
        User userById = getUserById(userId);

        List<Recipe> favouriteRecipiecListForUser = userById.getRecipes();
        Recipe toEditRecipe = entityManager.find(Recipe.class, recipeId);

        if (favouriteRecipiecListForUser.stream().anyMatch(r -> recipeId.equals(r.getId()))) {
            favouriteRecipiecListForUser.remove(toEditRecipe);
        } else {

            favouriteRecipiecListForUser.add(toEditRecipe);
        }
        userById.setRecipes(favouriteRecipiecListForUser);
    }
}

