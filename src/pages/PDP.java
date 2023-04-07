package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PDP extends BasePage {
    public PDP(WebDriver driver){
        super(driver);
    }

    By addPackpackToCartBy = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
    By navigateToCartBy = By.xpath ("//*[@id='shopping_cart_container']/a");

    String expectedRemove = "Remove";
    By backpackAddedToCart = By.xpath("//*[@id='remove-sauce-labs-backpack']");
    By removeBackpackFromCart = By.xpath("//*[@id='remove-sauce-labs-backpack']");

    By backToProductsBy = By.xpath("//button[@data-test='back-to-products']");

    String expectedAdd = "Add to cart";
    By addBackpackToCartAgainBy = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");

    public PDP verifyThatUserIsOnPDP(){
        checkIfElementIsVisible(backToProductsBy);
        return this;
    }
    

    public PDP addBackpackToCartPDP () {
        click (addPackpackToCartBy);
        return this;

    }

    public PDP navigateToCartPDP (){
        click (navigateToCartBy);
        return this;

    }

    public PDP verifyThatBackpackIsinCart (){
        String curentTextOnPDP = readText(backpackAddedToCart);
        checkIfTextIsTheSame(curentTextOnPDP, expectedRemove);
        return this;

    }

    public PDP removeFromCartPDP (){
        click (removeBackpackFromCart);
        return this;
    }

    public PDP verifyThatBackpackIsRemovedFromCart (){
        String currentTextOnPDP = readText(addBackpackToCartAgainBy);
        checkIfTextIsTheSame(currentTextOnPDP, expectedAdd);
        return this;
    }
}
