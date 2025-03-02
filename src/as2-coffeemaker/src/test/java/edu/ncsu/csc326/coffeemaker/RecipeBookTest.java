package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    * deleteRecipe never allows for new one to be added
    * editRecipe deletes mew recipe's name
    * In Recipe, same exception message for negative integer or invalid string passed which is not helpful
*/


class RecipeBookTest {

    private RecipeBook recipeBook;
    private Recipe blackCoffee;
    private Recipe latte ;
    private Recipe mocha;
    private Recipe heartAttack;
    private Recipe coffeeOne;
    private Recipe uninitialised;


    @BeforeEach
    void setUp() throws RecipeException {
        this.recipeBook = new RecipeBook();

        this.blackCoffee = new Recipe();
        blackCoffee.setName("Black Coffee");
        blackCoffee.setPrice("50");
        blackCoffee.setAmtCoffee("3");
        blackCoffee.setAmtMilk("0");
        blackCoffee.setAmtSugar("1");
        blackCoffee.setAmtChocolate("0");

        this.latte = new Recipe();
        latte.setName("Latte");
        latte.setPrice("75");
        latte.setAmtCoffee("2");
        latte.setAmtMilk("3");
        latte.setAmtSugar("2");
        latte.setAmtChocolate("0");

        this.mocha = new Recipe();
        mocha.setName("Mocha");
        mocha.setPrice("100");
        mocha.setAmtCoffee("2");
        mocha.setAmtMilk("2");
        mocha.setAmtSugar("2");
        mocha.setAmtChocolate("2");

        this.heartAttack = new Recipe();
        heartAttack.setName("Heart Attack");
        heartAttack.setPrice("100");
        heartAttack.setAmtCoffee("1000");
        heartAttack.setAmtMilk("800");
        heartAttack.setAmtSugar("100");
        heartAttack.setAmtChocolate("49");

        this.coffeeOne = new Recipe();
        coffeeOne.setName("Latte");
        coffeeOne.setPrice("75");
        coffeeOne.setAmtCoffee("2");
        coffeeOne.setAmtMilk("3");
        coffeeOne.setAmtSugar("2");
        coffeeOne.setAmtChocolate("0");
    }


    // Tests the constructor -------------------------------------------------------------------------------------------


    @Test   // Verifies the fields after executing the constructor of RecipeBook.
    public void testRecipeBookConstructor(){
        assertEquals(4, this.recipeBook.getRecipes().length);
    }

    // Tests for Get Recipes Function ----------------------------------------------------------------------------------

    @Test
    void testGetRecipes() {
        this.recipeBook.addRecipe(this.blackCoffee);
        this.recipeBook.addRecipe(this.latte);
        this.recipeBook.addRecipe(this.mocha);

        Recipe[] expectedRecipeArray = {this.blackCoffee, this.latte, this.mocha, null};
        Recipe[] actualRecipeArray = this.recipeBook.getRecipes();

        assertArrayEquals(expectedRecipeArray, actualRecipeArray);

    }

    //Tests for Add Recipe Function -----------------------------------------------------------------------------------

    @Test
    void testAddRecipe_Valid(){
        assertTrue(this.recipeBook.addRecipe(this.blackCoffee));
    }

    @Test
    void testAddRecipe_RepeatedRecipe() {

        this.recipeBook.addRecipe(mocha);
        assertFalse(this.recipeBook.addRecipe(mocha));
    }

    // ONLY ONE TEST WITH ALL ASSERTIONS COULD WORK
    @Test
    void testAddRecipe_TooManyRecipes() {

        this.recipeBook.addRecipe(blackCoffee);
        this.recipeBook.addRecipe(latte);
        this.recipeBook.addRecipe(mocha);
        this.recipeBook.addRecipe(heartAttack);
        assertFalse(this.recipeBook.addRecipe(coffeeOne));
    }

    @Test
    void testAddRecipe_NullRecipe(){
        assertThrows(
                NullPointerException.class, () -> {
                    this.recipeBook.addRecipe(null);
                }
        );
    }

    @Test
    void testAddRecipe_Uinstantiated(){
        assertThrows(
                NullPointerException.class, () -> {
                    this.recipeBook.addRecipe(null);
                }
        );
    }

    // CAN I DO THIS IN UNIT TESTS????
    @Test
    void testAddRecipe_AddRecipeAfterDeletionToMakeSpace() {
        this.recipeBook.addRecipe(blackCoffee);
        this.recipeBook.addRecipe(latte);
        this.recipeBook.addRecipe(mocha);
        this.recipeBook.addRecipe(heartAttack);
        this.recipeBook.deleteRecipe(0);

        assertTrue(this.recipeBook.addRecipe(coffeeOne));
    }

    //Tests for Delete Recipe Function -----------------------------------------------------------------------------------

    @Test
    void testDeleteRecipe_Valid() {
        this.recipeBook.addRecipe(mocha);

        String expectedDeletion = "Mocha";
        String actualDeletion = this.recipeBook.deleteRecipe(0);

        assertEquals(expectedDeletion, actualDeletion);
    }

    @Test
    void testDeleteRecipe_NullRecipe() {
        String actualDeletion = this.recipeBook.deleteRecipe(0);

        assertNull(actualDeletion);
    }

    @Test
    void testDeleteRecipe_IndexOutOfBounds() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class, () -> {
                    //Try to delete a recipe out of the array range
                    this.recipeBook.deleteRecipe(4);
                }
        );
    }

    //Tests for Edit Recipe Function -----------------------------------------------------------------------------------

    @Test
    void testEditRecipe_Valid() {
        this.recipeBook.addRecipe(this.blackCoffee);

        assertEquals("Black Coffee", this.recipeBook.editRecipe(0, mocha));
    }

    // What if the new recipe is null??
    @Test
    void testEditRecipe_NullIndex() {
        assertNull(this.recipeBook.editRecipe(0, mocha));

    }

    @Test
    void testEditRecipe_IndexOutOfBounds() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class, () -> {
                    //Try to delete a recipe out of the array range
                    this.recipeBook.editRecipe(4, this.blackCoffee);
                }
        );
    }

    @Test
    void testEditRecipe_NullRecipe() {
        this.recipeBook.addRecipe(this.blackCoffee);
        assertThrows(
                NullPointerException.class, () -> {
                    this.recipeBook.editRecipe(0, null);
                }
        );
    }

    @Test
    void testEditRecipe_Uninstantiated() {
        this.recipeBook.addRecipe(this.blackCoffee);
        assertThrows(
                NullPointerException.class, () -> {
                    this.recipeBook.editRecipe(0, this.uninitialised);
                }
        );
    }

    // CAN I DO THIS??? OPINIONS??
    @Test
    void testEditRecipe_NewRecipeCheck() {
        this.recipeBook.addRecipe(this.blackCoffee);
        this.recipeBook.editRecipe(0, mocha);

        String expectedName = "Mocha";
        String actualName = this.recipeBook.getRecipes()[0].getName();

        assertEquals(expectedName, actualName);

    }
}