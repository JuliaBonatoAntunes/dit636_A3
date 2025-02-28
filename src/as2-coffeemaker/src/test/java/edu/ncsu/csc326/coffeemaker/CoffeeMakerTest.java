package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoffeeMakerTest {

    private CoffeeMaker cm;
    private Recipe r1;
    private Recipe r2;
    private Recipe r3;
    private Recipe r4;
    private Recipe r5;
    private Recipe r6;

    @BeforeEach
    public void setUp() throws Exception{
        cm = new CoffeeMaker();

        //Set up for r1
        r1 = new Recipe();
        r1.setName("Black Coffee");
        r1.setAmtChocolate("0");
        r1.setAmtCoffee("3");
        r1.setAmtMilk("0");
        r1.setAmtSugar("0");
        r1.setPrice("25");

        //Set up for r2
        r2 = new Recipe();
        r2.setName("Sweet Milk");
        r2.setAmtChocolate("0");
        r2.setAmtCoffee("0");
        r2.setAmtMilk("2");
        r2.setAmtSugar("2");
        r2.setPrice("20");

        //Set up for r3
        r3 = new Recipe();
        r3.setName("Latte");
        r3.setAmtChocolate("0");
        r3.setAmtCoffee("2");
        r3.setAmtMilk("2");
        r3.setAmtSugar("2");
        r3.setPrice("30");

        //Set up for r4
        r4 = new Recipe();
        r4.setName("Hot Chocolate");
        r4.setAmtChocolate("3");
        r4.setAmtCoffee("0");
        r4.setAmtMilk("1");
        r4.setAmtSugar("3");
        r4.setPrice("25");

        //Set up for r5
        r5 = new Recipe();
        r5.setName("Cappuccino");
        r5.setAmtChocolate("2");
        r5.setAmtCoffee("2");
        r5.setAmtMilk("1");
        r5.setAmtSugar("2");
        r5.setPrice("30");

    }

    //Tests for Add Recipe Function ------------------------------------------------------------------------------------

    @Test
    public void testAddRecipe_Normal(){
        boolean result = false;
        try {
            //Add only one recipe
            result = cm.addRecipe(r1);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        //Check if shows that it added the recipe
        assertTrue(result);
    }

    @Test
    public void testAddRecipe_Twice(){
        boolean result = false;
        try {
            //Add same recipe twice
            cm.addRecipe(r1);
            result = cm.addRecipe(r1);

        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        //Check if it recognizes that the recipe was already there
        assertFalse(result);
    }

    @Test
    public void testAddRecipe_MoreThanAllowed(){
        boolean result = false;
        try {
            //Add many recipes
            cm.addRecipe(r1);
            cm.addRecipe(r2);
            cm.addRecipe(r3);
            cm.addRecipe(r4);
            result = cm.addRecipe(r5);

        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        //RecipeBook only allows 4 recipes, so it shouldn't allow us to add a 5th one
        assertFalse(result);
    }

    @Test
    public void testAddRecipe_NonInstantiated(){
        Throwable exception = assertThrows(
                Exception.class, () -> cm.addRecipe(r6)
        );
    }

    //Tests for Delete Recipe Function ---------------------------------------------------------------------------------

    @Test
    public void testDeleteRecipe_Normal(){
        String result = "";
        try {
            //Add only recipe and delete it
            cm.addRecipe(r1);
            result = cm.deleteRecipe(0);

        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        String expected = "Black Coffee";
        //Check if returns the correct name
        assertEquals(expected,result);
    }

    @Test
    public void testDeleteRecipe_NonExistent(){
        String result = "";
        try {
            //Delete recipe without adding anything
            result = cm.deleteRecipe(0);

        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        assertNull(result);
    }

    @Test
    public void testDeleteRecipe_IndexOutOfRange(){
        Throwable exception = assertThrows(
                ArrayIndexOutOfBoundsException.class, () -> {
                    //Try to delete a recipe out of the array range
                    cm.deleteRecipe(5);
                }
        );

    }

    //Tests for Edit Recipe Function -----------------------------------------------------------------------------------

    @Test
    public void testEditRecipe_Normal(){
        String result = "";
        try {
            //Add and edit recipe
            cm.addRecipe(r3);
            result = cm.editRecipe(0, r3);

        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        String expected = "Latte";
        assertEquals(expected, result);
    }

    @Test
    public void testEditRecipe_NonExistent(){
        String result = "";
        try {
            //Edit non-initialized recipe
            result = cm.editRecipe(0, r6);

        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
        assertNull(result);
    }

    @Test
    public void testEditRecipe_IndexOutOfRange(){
        Throwable exception = assertThrows(
                ArrayIndexOutOfBoundsException.class, () -> {
                    //Try to edit a recipe out of the array range
                    cm.editRecipe(5, r4);
                }
        );

    }

    //Tests for Add Inventory Function ---------------------------------------------------------------------------------

    //Why does this one throws an error?
    //Sugar has the wrong operator
    @Test
    public void testAddInventory_Normal(){
        try {
            cm.addInventory("10", "5", "6", "4");
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
        String result = cm.checkInventory();
        String expected = "Coffee: 25\nMilk: 20\nSugar: 21\nChocolate: 19\n";
        assertEquals(expected,result);
    }

    @Test
    public void testAddInventory_Exception(){
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    //Adding negative amounts to inventory, should throw an exception
                    cm.addInventory("-1", "-1", "-1", "-1");
                }
        );
    }

    @Test
    public void testAddInventory_Nothing(){
        try {
            //Adding nothing to inventory
            cm.addInventory("0", "0", "0", "0");
        } catch (InventoryException e) {
            fail("InventoryException should not be thrown");
        }
        String result = cm.checkInventory();
        //Since nothing is added, we remain with 15 items
        String expected = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(expected,result);
    }

    @Test
    public void testAddInventory_Many(){
        try {
            //Adding big amounts of items to the inventory
            cm.addInventory("100", "100", "100", "100");
        } catch (InventoryException e) {
            //Shouldn't throw an exception since we're just adding a big amount
            fail("InventoryException should not be thrown");
        }
        String result = cm.checkInventory();
        String expected = "Coffee: 115\nMilk: 115\nSugar: 115\nChocolate: 115\n";
        assertEquals(expected, result);
    }

    @Test
    public void testAddInventory_Strings(){
        Throwable exception = assertThrows(
                InventoryException.class, () -> {
                    //Adding invalid input (strings) to inventory, should throw an exception
                    cm.addInventory("bla", "bla", "bla", "bla");
                }
        );
    }

    //Tests for Make Coffee Function -----------------------------------------------------------------------------------

    @Test
    public void testMakeCoffee_Normal(){
        int change = 0;
        try{
            cm.addRecipe(r3);
            cm.addRecipe(r4);
            cm.addRecipe(r5);
            change = cm.makeCoffee(2, 30);

        }catch (Exception e){
            fail("Exception should not be thrown");
        }
        int expected = 0;
        assertEquals(expected, change);
    }

    @Test
    public void testMakeCoffee_NoRecipe(){
        int change = 0;
        try{

            //Adding some recipes for the test
            cm.addRecipe(r3);
            cm.addRecipe(r4);
            cm.addRecipe(r5);

            //Try to make a recipe out the range of the Recipe book array
            change = cm.makeCoffee(3, 30);

        }catch (Exception e){
            fail("Exception should not be thrown");
        }
        //Expect full refund
        int expected = 30;
        assertEquals(expected, change);
    }

    @Test
    public void testMakeCoffee_NoIngredients(){
        int change = 0;
        try{

            //Adding one recipe to test
            cm.addRecipe(r3);

            //Make multiple coffees until items run out
            for(int i = 0; i < 4; i++){
                cm.makeCoffee(0, 25);
            }

            //Try to make a coffee when the item has run out
            change = cm.makeCoffee(0, 25);

        }catch (Exception e){
            fail("Exception should not be thrown");
        }

        //Expect full refund
        int expected = 25;
        assertEquals(expected, change);
    }

    @Test
    public void testMakeCoffee_InsufficientPayment(){
        int change = 0;
        try{
            cm.addRecipe(r3);
            cm.addRecipe(r4);
            cm.addRecipe(r5);
            change = cm.makeCoffee(1, 20);

        }catch (Exception e){
            fail("Exception should not be thrown");
        }
        int expected = 20;
        assertEquals(expected, change);
    }

    //Tests for Get Recipes Function -----------------------------------------------------------------------------------

    @Test
    public void testGetRecipes(){
        Recipe result [] = {};
        try{
            cm.addRecipe(r2);
            cm.addRecipe(r3);
            cm.addRecipe(r4);
            cm.addRecipe(r5);
            result = cm.getRecipes();

        }catch (Exception e){
            fail("Exception should not be thrown");
        }

        Recipe [] expected = {r2, r3, r4, r5};

        for(int i = 0; i < result.length; i++){
            assertEquals(expected[i], result[i]);
        }

    }
}
