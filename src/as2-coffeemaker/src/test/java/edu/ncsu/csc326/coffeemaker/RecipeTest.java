package edu.ncsu.csc326.coffeemaker;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class RecipeTest {

    private Recipe recipe;

    @BeforeEach
    public void setUp(){
        // Instantiate new recipe object
        this.recipe = new Recipe();

    }
    @Test   // Verifies the fields after executing the constructor of Recipe.
    public void testRecipeConstructor(){
        String expectedName = "";
        int expectedPrice = 0;
        int expectedAmtCoffee = 0;
        int expectedAmtMilk = 0;
        int expectedAmtSugar = 0;
        int expectedAmtChocolate = 0;

        String actualName = this.recipe.getName();
        int actualPrice = this.recipe.getPrice();
        int actualAmtCoffee = this.recipe.getAmtCoffee();
        int actualAmtMilk = this.recipe.getAmtMilk();
        int actualAmtSugar = this.recipe.getAmtSugar();
        int actualAmtChocolate = this.recipe.getAmtChocolate();

        assertEquals(expectedName, actualName);
        assertEquals(expectedPrice, actualPrice);
        assertEquals(expectedAmtCoffee, actualAmtCoffee);
        assertEquals(expectedAmtMilk, actualAmtMilk);
        assertEquals(expectedAmtSugar, actualAmtSugar);
        assertEquals(expectedAmtChocolate, actualAmtChocolate);

    }

    /*************************** GETTERS ***************************/
    @Test
    void testGetName() {
        String expectedName = "";
        String actualName = this.recipe.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    void testGetPrice() {
        int expectedPrice = 0;
        int actualPrice = this.recipe.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void testGetAmtCoffee() {
        int expectedAmtCoffee = 0;
        int actualAmtCoffee = this.recipe.getAmtCoffee();

        assertEquals(expectedAmtCoffee, actualAmtCoffee);
    }

    @Test
    void testGetAmtMilk() {
        int expectedAmtMilk = 0;
        int actualAmtMilk = this.recipe.getAmtMilk();

        assertEquals(expectedAmtMilk, actualAmtMilk);
    }

    @Test
    void testGetAmtSugar() {
        int expectedAmtSugar = 0;
        int actualAmtSugar = this.recipe.getAmtSugar();

        assertEquals(expectedAmtSugar, actualAmtSugar);
    }

    @Test
    void testGetAmtChocolate() {
        int expectedAmtChocolate = 0;
        int actualAmtChocolate = this.recipe.getAmtChocolate();

        assertEquals(expectedAmtChocolate, actualAmtChocolate);
    }
    /*************************************************************************************/

    /**************************** SETTERS FOR ALL INGREDIENTS ****************************/

    @Test
    void testSetName_Normal() {
        String testName = "Recipe 1x-0%2";
        this.recipe.setName(testName);

        String actualName = this.recipe.getName();

        assertEquals(testName, actualName);
    }

    @Test
    void testSetName_Null() {
        this.recipe.setName("First");
        this.recipe.setName(null);

        String expectedName = "First";
        String actualName = this.recipe.getName();

        assertEquals(expectedName, actualName);
    }

    @Test
    void testSetPrice_Valid() throws RecipeException {
        String testPrice = "10";
        this.recipe.setPrice(testPrice);

        int expectedPrice = 10;
        int actualPrice = this.recipe.getPrice();

        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    void testSetPrice_Invalid() {
        String testPrice = "ten";
        String expectedMessage = "Price must be a positive integer";

        String actualMessage = assertThrows(RecipeException.class, () -> {
            this.recipe.setPrice(testPrice);
        }).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetPrice_Negative(){
        String testPrice = "-10";
        String expectedMessage = "Price must be a positive integer";// Different messages would be better to better
                                                                    // specify the origin of the error.
        String actualMessage = assertThrows(RecipeException.class, () -> {
            this.recipe.setPrice(testPrice);
        }).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtCoffee_Valid() throws RecipeException {
        String testAmtCoffee = "20";
        this.recipe.setAmtCoffee(testAmtCoffee);

        int expectedAmtCoffee = 20;
        int actualAmtCoffee = this.recipe.getAmtCoffee();

        assertEquals(expectedAmtCoffee, actualAmtCoffee);
    }

    @Test
    void testSetAmtCoffee_Invalid() {
        String testAmtCoffee = "twenty";
        String expectedMessage = "Units of coffee must be a positive integer";

        String actualMessage = assertThrows(RecipeException.class, () -> {
            this.recipe.setAmtCoffee(testAmtCoffee);
        }).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtCoffee_Negative() {
        String testAmtCoffee = "-20";
        String expectedMessage = "Units of coffee must be a positive integer"; // Different messages would be better to
                                                                              // better specify the origin of the error.
        String actualMessage = assertThrows(RecipeException.class, () -> {
            this.recipe.setAmtCoffee(testAmtCoffee);
        }).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtMilk_Valid() throws RecipeException {
        String testAmtMilk = "15";
        this.recipe.setAmtMilk(testAmtMilk);

        int expectedAmtMilk = 15;
        int actualAmtMilk = this.recipe.getAmtMilk();

        assertEquals(expectedAmtMilk, actualAmtMilk);
    }

    @Test
    void testSetAmtMilk_Invalid() {
        String testAmtMilk = "fifteen";
        String expectedMessage = "Units of milk must be a positive integer";

        String actualMessage = assertThrows(RecipeException.class, () -> {
            this.recipe.setAmtMilk(testAmtMilk);
        }).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtMilk_Negative() {
        String testAmtMilk = "-15";
        String expectedMessage = "Units of milk must be a positive integer";

        String actualMessage = assertThrows(RecipeException.class, () -> {
            this.recipe.setAmtMilk(testAmtMilk);
        }).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtSugar_Valid() throws RecipeException {
        String testAmtSugar = "10";
        this.recipe.setAmtSugar(testAmtSugar);

        int expectedAmtSugar = 10;
        int actualAmtSugar = this.recipe.getAmtSugar();

        assertEquals(expectedAmtSugar, actualAmtSugar);
    }

    @Test
    void testSetAmtSugar_Invalid() {
        String testAmtSugar = "ten";
        String expectedMessage = "Units of sugar must be a positive integer";

        String actualMessage = assertThrows(RecipeException.class, () -> {
            this.recipe.setAmtSugar(testAmtSugar);
        }).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtSugar_Negative() {
        String testAmtSugar = "-10";
        String expectedMessage = "Units of sugar must be a positive integer";

        String actualMessage = assertThrows(RecipeException.class, () -> {
            this.recipe.setAmtSugar(testAmtSugar);
        }).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtChocolate_Valid() throws RecipeException {
        String testAmtChocolate = "5";
        this.recipe.setAmtChocolate(testAmtChocolate);

        int expectedAmtChocolate = 5;
        int actualAmtChocolate = this.recipe.getAmtChocolate();

        assertEquals(expectedAmtChocolate, actualAmtChocolate);
    }

    @Test
    void testSetAmtChocolate_Invalid() {
        String testAmtChocolate = "five";
        String expectedMessage = "Units of chocolate must be a positive integer";

        String actualMessage = assertThrows(RecipeException.class, () -> {
            this.recipe.setAmtChocolate(testAmtChocolate);
        }).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetAmtChocolate_Negative() {
        String testAmtChocolate = "-5";
        String expectedMessage = "Units of chocolate must be a positive integer";

        String actualMessage = assertThrows(RecipeException.class, () -> {
            this.recipe.setAmtChocolate(testAmtChocolate);
        }).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
    /*************************************************************************************/


    /******************** Object Methods (toString, hashCode, equals) *********************/

    @Test
    void testToString() {
        this.recipe.setName("Espresso");
        String expectedName = "Espresso";
        String actualName = this.recipe.toString();

        assertEquals(expectedName, actualName);
    }

    @Test
    void testHashCode_Normal() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();

        recipe1.setName("Latte");
        recipe2.setName("Latte");

        assertEquals(recipe1.hashCode(), recipe2.hashCode());
    }

    @Test
    void testHashCode_Null() {
        Recipe recipe1 = new Recipe();
        recipe1.setName(null);

        assertEquals(31, recipe1.hashCode());
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(recipe.equals(recipe));  // Could have used assertEquals, but we are doing this to make
                                            // what is being tested explicit.
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(recipe.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(recipe.equals("Not a Recipe"));
    }

    @Test
    void testEquals_DifferentName() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();

        recipe1.setName("Mocha");
        recipe2.setName("Cappuccino");

        assertFalse(recipe1.equals(recipe2));
    }

    @Test
    void testEquals_SameName() {
        Recipe recipe1 = new Recipe();
        Recipe recipe2 = new Recipe();

        recipe1.setName("Mocha");
        recipe2.setName("Mocha");

        assertTrue(recipe1.equals(recipe2));
    }

}