package org.louakfaoui;

import org.louakfaoui.service.RecipeMaker;

public class Main {
    public static void main(String[] args) {

        String PRICES_FILE_NAME = "C:/FuitShop/Fruit Shop/src/main/resources/prices";
        String PURCHASE_FILE_NAME = "C:/FuitShop/Fruit Shop/src/main/resources/purchase";

        RecipeMaker.makeRecipe(PRICES_FILE_NAME, PURCHASE_FILE_NAME);
    }
}