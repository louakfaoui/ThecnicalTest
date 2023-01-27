package org.louakfaoui.service;

import org.louakfaoui.model.Recipe;

public class ApplesOffer implements Offer {
    @Override
    public void applyOffer(Recipe recipe) {

        recipe.getRecipeItems().stream()
                .filter(i -> "Apple".equals(i.getProduct()))
                .findFirst()
                .ifPresent(i -> {
                    int quantityDiscount = i.getQuantity() / 3;
                    if (quantityDiscount == 0) {
                        return;
                    }
                    recipe.addOfferMessage("You get " + quantityDiscount + " free Apples");
                    recipe.addDiscount(quantityDiscount * i.getUnitPrice());
                });

    }
}