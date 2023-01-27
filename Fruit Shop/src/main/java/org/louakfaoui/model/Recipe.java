package org.louakfaoui.model;

import java.util.LinkedList;
import java.util.List;

public class Recipe {

    private final List<RecipeItem> recipeItems = new LinkedList<>();
    private final List<String> offerMessages = new LinkedList<>();
    private float discount;

    public void calculateFinalRecipe() {
        float finalTotal = 0;
        for (RecipeItem recipeItem : recipeItems) {
            finalTotal += recipeItem.getTotalPrice();

            System.out.printf("Product %s, UnitPrice %s, Quantity %s, SubTotal %s%n",
                    recipeItem.getProduct(),
                    recipeItem.getUnitPrice(),
                    recipeItem.getQuantity(),
                    recipeItem.getTotalPrice());
        }

        if (!offerMessages.isEmpty()) {
            System.out.println("Offers :");
            offerMessages.forEach(System.out::println);
        }

        if (discount > 0) {
            System.out.println("Total discount : " + discount);
            finalTotal -= discount;
        }


        System.out.println("Total price : " + finalTotal);
    }

    public List<RecipeItem> getRecipeItems() {
        return recipeItems;
    }

    public void addOfferMessage(String offerMessage) {
        offerMessages.add(offerMessage);
    }

    public void addDiscount(float discount) {
        this.discount += discount;
    }

    public void addRecipeItem(RecipeItem recipeItem) {
        recipeItems.add(recipeItem);
    }
}
