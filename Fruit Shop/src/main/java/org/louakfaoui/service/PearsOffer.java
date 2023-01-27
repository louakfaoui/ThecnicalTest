package org.louakfaoui.service;

import org.louakfaoui.model.Recipe;

public class PearsOffer implements Offer {
    @Override
    public void applyOffer(Recipe recipe) {

        recipe.getRecipeItems().stream()
                .filter(i -> "Pear".equals(i.getProduct()))
                .findFirst()
                .ifPresent(i -> {
                    int orangeQuantityDiscount = i.getQuantity() / 2;
                    if (orangeQuantityDiscount == 0) {
                        return;
                    }
                    recipe.addOfferMessage("You get the " + orangeQuantityDiscount + " free Oranges");


                    int priceDiscount = (i.getQuantity() * (int) i.getUnitPrice()) / 4;
                    if (priceDiscount == 0) {
                        return;
                    }
                    recipe.addOfferMessage("You get " + priceDiscount + " € discount");
                    recipe.addDiscount(priceDiscount);
                });

    }
}