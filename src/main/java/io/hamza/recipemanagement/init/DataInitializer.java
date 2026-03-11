package io.hamza.recipemanagement.init;

import io.hamza.recipemanagement.chef.Chef;
import io.hamza.recipemanagement.chef.ChefService;
import io.hamza.recipemanagement.recipe.Recipe;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.text.SimpleDateFormat;  
import java.util.Date;


@Component
public class DataInitializer implements CommandLineRunner {

    private final ChefService chefService;

    public DataInitializer(ChefService chefService) {
        this.chefService = chefService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(chefService.getNumberOfChefs() > 1) {
            System.out.println("Chefs already initialized!");
            return;
        }

        String sDate1="31/12/1998";  
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  

        Chef chef1 = new Chef("Gordon Ramsayyy","jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta","01/08/1998");
        Chef chef2 = new Chef("Jamie Oliverrrr","jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta","02/08/1998");
        Chef chef3 = new Chef("Anthony Bourdainnn","jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta jakarta","03/08/1998");

        List<Recipe> chef1Recipes = Arrays.asList(
                new Recipe("Beef Wellington", "A classic British dish made with beef fillet, puff pastry, and mushroom duxelles."),
                new Recipe("Scrambled Eggs", "A simple breakfast dish made with eggs, butter, and salt."),
                new Recipe("Beef Burger", "A juicy burger made with high-quality beef, fresh vegetables, and a soft bun.")
        );

        List<Recipe> chef2Recipes = Arrays.asList(
                new Recipe("Spaghetti Carbonara", "A creamy pasta dish made with spaghetti, pancetta, eggs, and parmesan cheesee."),
                new Recipe("Roast Chicken", "A classic roast chicken dish made with herbs, lemon, and garlic."),
                new Recipe("Fish and Chips", "A traditional British dish made with battered fish and deep-fried chips.")
        );

        chefService.createChefWithRecipes(chef1,chef1Recipes);
        chefService.createChefWithRecipes(chef2,chef2Recipes);
        chefService.createChefWithRecipes(chef3,new ArrayList<>());

    }
}
