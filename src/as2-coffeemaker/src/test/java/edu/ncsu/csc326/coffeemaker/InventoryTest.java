package edu.ncsu.csc326.coffeemaker;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

public class InventoryTest {
    
    private Inventory inv;
    private Recipe recipe;

    
    @BeforeEach
    public void setUp(){

        // Instantiate new inventory object
        this.inv = new Inventory();

        // Instantiate new recipe object
        this.recipe = new Recipe();
    }


    @Test   // Tests the inventory amounts when creating an inventory object
    public void testInventoryConstructor(){

        int expectedCoffeeAmount = 15;
        int expectedMilkAmount = 15;
        int expectedSugarAmount = 15;
        int expectedChocolateAmount = 15;

        int actualCoffeeAmount = this.inv.getCoffee();
        int actualMilkAmount = this.inv.getMilk();
        int actualSugarAmount = this.inv.getSugar();
        int actualChocolateAmount = this.inv.getChocolate();

        assertEquals(expectedCoffeeAmount, actualCoffeeAmount);
        assertEquals(expectedMilkAmount, actualMilkAmount);
        assertEquals(expectedSugarAmount, actualSugarAmount);
        assertEquals(expectedChocolateAmount, actualChocolateAmount);
    }



    /*************************** GETTERS FOR ALL INGREDIENTS ***************************/

    @Test   // Tests the getter for the chocolate attribute
    public void testGetChocolate(){

        int expectedChocolateAmount = 15;
        int actualChocolateAmount = this.inv.getChocolate();

        assertEquals(expectedChocolateAmount, actualChocolateAmount);
    }


    @Test   // Tests the getter for the coffee attribute
    public void testGetCoffee(){

        int expectedCoffeeAmount = 15;
        int actualCoffeeAmount = this.inv.getCoffee();

        assertEquals(expectedCoffeeAmount, actualCoffeeAmount);
    }


    @Test   // Tests the getter for the milk attribute
    public void testGetMilk(){

        int expectedMilkAmount = 15;
        int actualMilkAmount = this.inv.getMilk();

        assertEquals(expectedMilkAmount, actualMilkAmount);
    }


    @Test   // Tests the getter for the sugar attribute
    public void testGetSugar(){

        int expectedSugarAmount = 15;
        int actualSugarAmount = this.inv.getSugar();

        assertEquals(expectedSugarAmount, actualSugarAmount);
    }

    /*************************************************************************************/


    /**************************** SETTERS FOR ALL INGREDIENTS ****************************/


    @Test   // Tests the setter for the chocolate attribute with a negative number
    public void testSetChocolateWithNegativeValue(){

        // Attempt to set chocolate amount to -1
        this.inv.setChocolate(-1);

        // Expect chocolate amount to be the default
        int expectedChocolateAmount = 15;
        int actualChocolateAmount = this.inv.getChocolate();

        assertEquals(expectedChocolateAmount, actualChocolateAmount);
    }


    @Test   // Tests the setter for the chocolate attribute with the value 0
    public void testSetChocolateWithZero(){

        // Attempt to set chocolate amount to 0
        this.inv.setChocolate(0);

        int expectedChocolateAmount = 0;
        int actualChocolateAmount = this.inv.getChocolate();

        assertEquals(expectedChocolateAmount, actualChocolateAmount);
    }


    @Test   // Tests the setter for the chocolate attribute with the value 100
    public void testSetChocolateWithPositiveValue(){

        // Attempt to set chocolate amount to 100
        this.inv.setChocolate(100);

        int expectedChocolateAmount = 100;
        int actualChocolateAmount = this.inv.getChocolate();

        assertEquals(expectedChocolateAmount, actualChocolateAmount);
    }


    @Test   // Tests the setter for the coffee attribute with a negative number
    public void testSetCoffeeWithNegativeValue(){

        // Attempt to set coffee amount to -1
        this.inv.setCoffee(-1);

        // Expect coffee amount to be the default
        int expectedCoffeeAmount = 15;
        int actualCoffeeAmount = this.inv.getCoffee();

        assertEquals(expectedCoffeeAmount, actualCoffeeAmount);
    }


    @Test   // Tests the setter for the coffee attribute with the value 0
    public void testSetCoffeeWithZero(){

        // Attempt to set coffee amount to 0
        this.inv.setCoffee(0);

        int expectedCoffeeAmount = 0;
        int actualCoffeeAmount = this.inv.getCoffee();

        assertEquals(expectedCoffeeAmount, actualCoffeeAmount);
    }


    @Test   // Tests the setter for the coffee attribute with the value 100
    public void testSetCoffeeWithPositiveValue(){

        // Attempt to set coffee amount to 100
        this.inv.setCoffee(100);

        int expectedCoffeeAmount = 100;
        int actualCoffeeAmount = this.inv.getCoffee();

        assertEquals(expectedCoffeeAmount, actualCoffeeAmount);
    }


    @Test   // Tests the setter for the milk attribute with a negative number
    public void testSetMilkWithNegativeValue(){

        // Attempt to set milk amount to -1
        this.inv.setMilk(-1);

        // Expect milk amount to be the default
        int expectedMilkAmount = 15;
        int actualMilkAmount = this.inv.getMilk();

        assertEquals(expectedMilkAmount, actualMilkAmount);
    }


    @Test   // Tests the setter for the milk attribute with the value 0
    public void testSetMilkWithZero(){

        // Attempt to set milk amount to 0
        this.inv.setMilk(0);

        int expectedMilkAmount = 0;
        int actualMilkAmount = this.inv.getMilk();

        assertEquals(expectedMilkAmount, actualMilkAmount);
    }


    @Test   // Tests the setter for the milk attribute with the value 100
    public void testSetMilkWithPositiveValue(){

        // Attempt to set milk amount to 100
        this.inv.setMilk(100);

        int expectedMilkAmount = 100;
        int actualMilkAmount = this.inv.getMilk();

        assertEquals(expectedMilkAmount, actualMilkAmount);
    }


    @Test   // Tests the setter for the sugar attribute with a negative number
    public void testSetSugarWithNegativeValue(){

        // Attempt to set sugar amount to -1
        this.inv.setSugar(-1);

        // Expect sugar amount to be the default
        int expectedSugarAmount = 15;
        int actualSugarAmount = this.inv.getSugar();

        assertEquals(expectedSugarAmount, actualSugarAmount);
    }


    @Test   // Tests the setter for the sugar attribute with the value 0
    public void testSetSugarWithZero(){

        // Attempt to set sugar amount to 0
        this.inv.setSugar(0);

        int expectedSugarAmount = 0;
        int actualSugarAmount = this.inv.getSugar();

        assertEquals(expectedSugarAmount, actualSugarAmount);
    }


    @Test   // Tests the setter for the sugar attribute with the value 100
    public void testSetSugarWithPositiveValue(){

        // Attempt to set sugar amount to 100
        this.inv.setSugar(100);

        int expectedSugarAmount = 100;
        int actualSugarAmount = this.inv.getSugar();

        assertEquals(expectedSugarAmount, actualSugarAmount);
    }




    /**************************************************************************************/

    /**************************** 'ADDERS' FOR ALL INGREDIENTS ****************************/

    @Test   // Tests the add chocolate method with a positive integer
    public void testAddChocolateWithPositiveInteger() throws InventoryException{

        // Attempt to add 10 chocolates
        this.inv.addChocolate("10");

        // Default value + 10 is 25
        int expectedChocolateAmount = 25;
        int actualChocolateAmount = this.inv.getChocolate();

        assertEquals(expectedChocolateAmount, actualChocolateAmount);
    }


    @Test   // Tests the add chocolate method with the value "0"
    public void testAddChocolateWithZero() throws InventoryException {

        // Attempt to add 0 chocolates
        this.inv.addChocolate("0");

        // Default value is 15
        int expectedChocolateAmount = 15;
        int actualChocolateAmount = this.inv.getChocolate();

        assertEquals(expectedChocolateAmount, actualChocolateAmount);
    }


    @Test   // Tests the add chocolate method with an invalid value "one"
    public void testAddChocolateWithInvalidFormat() throws InventoryException{

        String expectedMessage = "Units of chocolate must be a positive integer";
        // Attempt to add "one" chocolate
        InventoryException actualMessage = assertThrows(InventoryException.class, () -> {
            this.inv.addChocolate("one");
        });

        assertEquals(expectedMessage, actualMessage.getMessage());
    }


    @Test   // Tests the add chocolate method with a negative value
    public void testAddChocolateWithNegativeValue() throws InventoryException{

        String expectedMessage = "Units of chocolate must be a positive integer";
        // Attempt to add "-1" chocolate
        InventoryException actualMessage = assertThrows(InventoryException.class, () -> {
            this.inv.addChocolate("-1");
        });

        assertEquals(expectedMessage, actualMessage.getMessage());
    }


    @Test   // Tests the add coffee method with a positive integer
    public void testAddCoffeeWithPositiveInteger() throws InventoryException{

        // Attempt to add 10 coffees
        this.inv.addCoffee("10");

        // Default value + 10 is 25
        int expectedCoffeeAmount = 25;
        int actualCoffeeAmount = this.inv.getCoffee();

        assertEquals(expectedCoffeeAmount, actualCoffeeAmount);
    }


    @Test   // Tests the add coffee method with the value "0"
    public void testAddCoffeeWithZero() throws InventoryException {

        // Attempt to add 0 coffees
        this.inv.addCoffee("0");

        // Default value is 15
        int expectedCoffeeAmount = 15;
        int actualCoffeeAmount = this.inv.getCoffee();

        assertEquals(expectedCoffeeAmount, actualCoffeeAmount);
    }


    @Test   // Tests the add coffee method with an invalid value "one"
    public void testAddCoffeeWithInvalidFormat() throws InventoryException{

        String expectedMessage = "Units of coffee must be a positive integer";
        // Attempt to add "one" coffee
        InventoryException actualMessage = assertThrows(InventoryException.class, () -> {
            this.inv.addCoffee("one");
        });

        assertEquals(expectedMessage, actualMessage.getMessage());
    }


    @Test   // Tests the add coffee method with a negative value
    public void testAddCoffeeWithNegativeValue() throws InventoryException{

        String expectedMessage = "Units of coffee must be a positive integer";
        // Attempt to add "-1" coffee
        InventoryException actualMessage = assertThrows(InventoryException.class, () -> {
            this.inv.addCoffee("-1");
        });

        assertEquals(expectedMessage, actualMessage.getMessage());
    }


    @Test   // Tests the add milk method with a positive integer
    public void testAddMilkWithPositiveInteger() throws InventoryException{

        // Attempt to add 10 milk
        this.inv.addMilk("10");

        // Default value + 10 is 25
        int expectedMilkAmount = 25;
        int actualMilkAmount = this.inv.getMilk();

        assertEquals(expectedMilkAmount, actualMilkAmount);
    }


    @Test   // Tests the add milk method with the value "0"
    public void testAddMilkWithZero() throws InventoryException {

        // Attempt to add 10 milk
        this.inv.addMilk("0");

        int expectedMilkAmount = 15;
        int actualMilkAmount = this.inv.getMilk();

        assertEquals(expectedMilkAmount, actualMilkAmount);
    }


    @Test   // Tests the add milk method with an invalid value "one"
    public void testAddMilkWithInvalidFormat() throws InventoryException{

        String expectedMessage = "Units of milk must be a positive integer";
        // Attempt to add "one" milk
        InventoryException actualMessage = assertThrows(InventoryException.class, () -> {
            this.inv.addMilk("one");
        });

        assertEquals(expectedMessage, actualMessage.getMessage());
    }


    @Test   // Tests the add milk method with a negative value
    public void testAddMilkWithNegativeValue() throws InventoryException{

        String expectedMessage = "Units of milk must be a positive integer";
        // Attempt to add -1 milk
        InventoryException actualMessage = assertThrows(InventoryException.class, () -> {
            this.inv.addMilk("-1");
        });

        assertEquals(expectedMessage, actualMessage.getMessage());
    }


    @Test   // Tests the add sugar method with a positive integer
    public void testAddSugarWithPositiveInteger() throws InventoryException{

        // Attempt to add 10 sugar
        this.inv.addSugar("10");

        // default + 10 = 25
        int expectedSugarAmount = 25;
        int actualSugarAmount = this.inv.getSugar();

        assertEquals(expectedSugarAmount, actualSugarAmount);
    }


    @Test   // Tests the add sugar method with the value "0"
    public void testAddSugarWithZero() throws InventoryException {

        // Attempt to add 0 sugar
        this.inv.addSugar("0");

        // Expect default value
        int expectedSugarAmount = 15;
        int actualSugarAmount = this.inv.getSugar();

        assertEquals(expectedSugarAmount, actualSugarAmount);
    }


    @Test   // Tests the add sugar method with an invalid value "one"
    public void testAddSugarWithInvalidFormat() throws InventoryException{

        String expectedMessage = "Units of sugar must be a positive integer";
        // Attempt to add "one" sugar
        InventoryException actualMessage = assertThrows(InventoryException.class, () -> {
            this.inv.addSugar("one");
        });

        assertEquals(expectedMessage, actualMessage.getMessage());
    }


    @Test   // Tests the add sugar method with a negative value
    public void testAddSugarWithNegativeValue() throws InventoryException{

        String expectedMessage = "Units of sugar must be a positive integer";
        // Attempt to add -1 sugar
        InventoryException actualMessage = assertThrows(InventoryException.class, () -> {
            this.inv.addSugar("-1");
        });

        assertEquals(expectedMessage, actualMessage.getMessage());
    }

    /**************************************************************************************/

    /********************************* GENERAL FUNCTIONS **********************************/

    @Test   // Tests the enough ingredients method with sufficient ingredients
    public void testHasEnoughIngredientsRecipeValid() throws RecipeException {

        // Set all ingredients to 5
        this.recipe.setAmtChocolate("5");
        this.recipe.setAmtCoffee("5");
        this.recipe.setAmtMilk("5");
        this.recipe.setAmtSugar("5");

        boolean actual = this.inv.enoughIngredients(this.recipe);

        assertTrue(actual);
    }


    @Test   // Tests the enough ingredients method with insufficient ingredients
    public void testHasEnoughIngredientsRecipeInvalid() throws RecipeException {

        // Set all ingredients to 25
        this.recipe.setAmtChocolate("25");
        this.recipe.setAmtCoffee("25");
        this.recipe.setAmtMilk("25");
        this.recipe.setAmtSugar("25");

        boolean actual = this.inv.enoughIngredients(this.recipe);

        assertFalse(actual);
    }


    @Test   // Tests the use ingredients method with sufficient ingredients
    public void testUseIngredientsRecipeValid() throws RecipeException {

        // Set all ingredients to 5
        this.recipe.setAmtChocolate("5");
        this.recipe.setAmtCoffee("5");
        this.recipe.setAmtMilk("5");
        this.recipe.setAmtSugar("5");

        boolean actual = this.inv.useIngredients(this.recipe);

        assertTrue(actual);
    }


    @Test   // Tests the use ingredients method with insufficient ingredients
    public void testUseIngredientsRecipeInvalid() throws RecipeException {

        // Set all ingredients to 25
        this.recipe.setAmtChocolate("25");
        this.recipe.setAmtCoffee("25");
        this.recipe.setAmtMilk("25");
        this.recipe.setAmtSugar("25");

        boolean actual = this.inv.useIngredients(this.recipe);

        assertFalse(actual);
    }


    @Test   // Tests if the inventory has the correct amounts after calling the use ingredients method with sufficient ingredients
    public void testCheckInventoryAfterUseIngredients() throws RecipeException {

        // Set all ingredients to 5
        this.recipe.setAmtChocolate("5");
        this.recipe.setAmtCoffee("5");
        this.recipe.setAmtMilk("5");
        this.recipe.setAmtSugar("5");

        this.inv.useIngredients(this.recipe);

        int expectedCoffeeAmount = 10;
        int expectedMilkAmount = 10;
        int expectedSugarAmount = 10;
        int expectedChocolateAmount = 10;

        int actualCoffeeAmount = this.inv.getCoffee();
        int actualMilkAmount = this.inv.getMilk();
        int actualSugarAmount = this.inv.getSugar();
        int actualChocolateAmount = this.inv.getChocolate();

        assertEquals(expectedCoffeeAmount, actualCoffeeAmount);
        assertEquals(expectedMilkAmount, actualMilkAmount);
        assertEquals(expectedSugarAmount, actualSugarAmount);
        assertEquals(expectedChocolateAmount, actualChocolateAmount);
    }


    @Test   // Tests the toString method
    public void testToString() throws RecipeException {

        int coffeeAmount = this.inv.getCoffee();
        int milkAmount = this.inv.getMilk();
        int sugarAmount = this.inv.getSugar();
        int chocolateAmount = this.inv.getChocolate();


        String expectedMessage = String.format("Coffee: %d\nMilk: %d\nSugar: %d\nChocolate: %d\n", coffeeAmount, milkAmount, sugarAmount, chocolateAmount);        
        String actualMessage = this.inv.toString();

        assertEquals(expectedMessage, actualMessage);
    }
}
