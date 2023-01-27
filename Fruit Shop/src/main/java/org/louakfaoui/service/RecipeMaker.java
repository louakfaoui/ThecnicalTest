package org.louakfaoui.service;

import org.louakfaoui.model.Recipe;
import org.louakfaoui.model.RecipeItem;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RecipeMaker {

    private final static List<Offer> OFFERS = Arrays.asList(new ApplesOffer(), new PearsOffer());

    public static void makeRecipe(String pricesFile, String purchaseFile) {

        Map<String, Float> prices = DataLoader.loadPrices(pricesFile);
        Map<String, Integer> purchase = DataLoader.loadPurchase(purchaseFile);

        Recipe recipe = new Recipe();
        for (Map.Entry<String, Integer> entry : purchase.entrySet()) {
            RecipeItem recipeItem = new RecipeItem();
            String product = entry.getKey();
            recipeItem.setProduct(product);
            recipeItem.setQuantity(entry.getValue());
            recipeItem.setUnitPrice(prices.get(product));
            recipeItem.calculateTotalPrice();
            recipe.addRecipeItem(recipeItem);
        }

        OFFERS.forEach(f -> f.applyOffer(recipe));

        recipe.calculateFinalRecipe();

    }
}
