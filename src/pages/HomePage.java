package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver){
        super(driver);
    }

    By pageTitleBy = By.xpath("//span[@class='title']");
    String expectedPageTitle = "Products";
    By hamburgerMenuIconBy = By.id("react-burger-menu-btn");
    By logoutLinkBy = By.id("logout_sidebar_link");
    By backpackProductBy = By.xpath("//a[@id='item_4_title_link']/div");
    By allItemsBy = By.id("inventory_sidebar_link");
    By cartBy = By.className("shopping_cart_link");
    By aboutLinkBy = By.id("about_sidebar_link");
    String expectedHref = "https://saucelabs.com/";
    By productsBy = By.xpath("//div[@class='inventory_item']");
    int expectedNumberOfProducts = 6;
    By sortSelectBy = By.xpath("//select[@class='product_sort_container']");
    By productsTitleBy = By.xpath("//div[@class='inventory_item_name']");
    By productsPriceBy = By.xpath("//div[@class='inventory_item_price']");
    By addBackpackToCartBy = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
    By backpackCartBy = By.xpath("//*[@id='item_4_title_link']/div");
    String expectedCartText = "Sauce Labs Backpack";
    By removeBackpackFromCartBy = By.xpath ("//*[@id='remove-sauce-labs-backpack']");
    By backpackRemovedFromCartBy = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
    String expectedRemovedBackpackText = "Add to cart";
    public Object verifyThatBackpackIsInCart;

    public HomePage checkIfUserIsOnHomePage(){
        String curentPageTitle = readText(pageTitleBy);
        checkIfTextIsTheSame(expectedPageTitle, curentPageTitle);
        return this;
    }

    public HomePage expandMenu(){
        click(hamburgerMenuIconBy);
        return this;
    }

    public HomePage clickOnLogoutLink(){
        click(logoutLinkBy);
        return this;
    }

    public HomePage navigateToPDP(){
        click(backpackProductBy);
        return this;
    }

    public HomePage clickOnAllItemsLink(){
        click(allItemsBy);
        return this;
    }

    public HomePage navigateToCart(){
        click(cartBy);
        return this;
    }

    public HomePage verifyAboutLink(){
        String foundHref = readHref(aboutLinkBy);
        checkIfTextIsTheSame(expectedHref, foundHref);
        return this;
    }

    public HomePage verifyNumberOfProducts(){
        int foundItems = countItems(productsBy);
        checkIfNumberIsTheSame(expectedNumberOfProducts, foundItems);
        return this;
    }

    public HomePage selectSortOption(String option){
        selectDropdownOptionByValue(sortSelectBy, option);
        return this;
    }

    public HomePage verifyFirstProductTitle(String expectedTitle){
        String foundTitle = readText(productsTitleBy);
        checkIfTextIsTheSame(expectedTitle, foundTitle);
        return this;
    }

    public HomePage verifyFirstProductPrice(double expectedPrice){
        String foundPrice = readText(productsPriceBy);
        double foundPriceDouble = parseStringToDouble(foundPrice.substring(1));
        checkIfNumberIsTheSame(expectedPrice, foundPriceDouble);
        return this;
    }

    public HomePage addToCartBackpack () {
        click (addBackpackToCartBy);
        return this;
    }
    
    public HomePage verifyThatBackpackIsInCart (){
        String curentCartTitle = readText(backpackCartBy);
        checkIfTextIsTheSame (expectedCartText, curentCartTitle);
        return this;

    }

    public HomePage removeFromCartBackpack(){
        click (removeBackpackFromCartBy);
        return this;
    }

    public HomePage verifyThatBackpackIsRemovedFromCart (){
        String curentHomePageItemTitle = readText(backpackRemovedFromCartBy);
        checkIfTextIsTheSame(curentHomePageItemTitle, expectedRemovedBackpackText);
        return this;
    }
}
