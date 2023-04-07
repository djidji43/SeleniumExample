package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver){
        super(driver);
    }

    By cartPageTitleBy = By.className("title");
    String expectedTitle = "Your Cart";

    By removeItemBy = By.xpath("//*[@id='remove-sauce-labs-backpack']");

    String expectedNumberOfProductsInCart = "1";
    By isCartEmptyOrNot = By.xpath("//*[@id=shopping_cart_container']/a/span");

    public CartPage verifyThatUserIsOnCartPage(){
        String actualTitle = readText(cartPageTitleBy);
        checkIfTextIsTheSame(expectedTitle, actualTitle);
        return this;
    }

    public CartPage removeItemFromCartOnCart(){
        click (removeItemBy);
        return this; 

    }

    public CartPage verifyIfCartIsEmpty (){
        verifyIfElement
        return this;

    }

    public void verifyIfCartIsNotEmpty (){
        boolean isNotVisible;

        try{
            waitVisible(isCartEmptyOrNot);
            isNotVisible = !driver.findElement(isCartEmptyOrNot).isDisplayed();
        }
        catch (Exception e){
            isNotVisible = true;
        }

    
    }
    
}
