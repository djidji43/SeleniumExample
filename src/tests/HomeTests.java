package tests;

import org.junit.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PDP;

public class HomeTests extends BaseTest {
    String sortZtoA = "za";
    String expectedZtoAfirstProduct = "Test.allTheThings() T-Shirt (Red)";
    String sortAtoZ = "az";
    String expectedAtoZfirstProduct = "Sauce Labs Backpack";
    String sortLoToHigh = "lohi";
    double expectedLoToHighProduct = 7.99;
    String sortHighToLow = "hilo";
    double expectedHighToLowProduct = 49.99;

    @Test
    public void validateAllItemsLink(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.navigateToPDP();
        homePage.expandMenu();
        homePage.clickOnAllItemsLink();
        homePage.checkIfUserIsOnHomePage();
    }

    @Test
    public void validatePDPNavigation(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PDP pdp = new PDP(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.navigateToPDP();
        pdp.verifyThatUserIsOnPDP();
    }

    @Test
    public void verifyCartNavigation(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.navigateToCart();
        cartPage.verifyThatUserIsOnCartPage();
    }

    @Test
    public void verifyAboutNavigation(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.expandMenu();
        homePage.verifyAboutLink();
    }

    @Test
    public void verifyNumberOfProductsOnHomepage(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.verifyNumberOfProducts();
    }

    @Test
    public void verifyProductSortingFromZtoA(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.selectSortOption(sortZtoA);
        homePage.verifyFirstProductTitle(expectedZtoAfirstProduct);
    }

    @Test
    public void verifyProductSortingFromAtoZ(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.selectSortOption(sortZtoA);
        homePage.selectSortOption(sortAtoZ);
        homePage.verifyFirstProductTitle(expectedAtoZfirstProduct);
    }

    @Test
    public void verifyProductsSortingFromLowToHigh(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.selectSortOption(sortLoToHigh);
        homePage.verifyFirstProductPrice(expectedLoToHighProduct);
    }

    @Test
    public void verifyProductsSortingFromHighToLow(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.selectSortOption(sortHighToLow);
        homePage.verifyFirstProductPrice(expectedHighToLowProduct);
    }

    @Test
    public void verifyThatItemIsAddedToCart(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.addToCartBackpack();
        homePage.navigateToCart();
        homePage.verifyThatBackpackIsInCart ();
    }

    @Test
    public void verifyThatItemIsRemovedFromCart (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.addToCartBackpack();
        homePage.removeFromCartBackpack();
        homePage.verifyThatBackpackIsRemovedFromCart();
    }

    @Test

    public void verifyThatItemIsInCartPDP (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PDP pdp = new PDP (driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.navigateToPDP();
        pdp.addBackpackToCartPDP();
        pdp.verifyThatBackpackIsinCart();
    }

    @Test

    public void verifyThatItemIsRemovedFromCartPDP (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        PDP pdp = new PDP (driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.navigateToPDP();
        pdp.addBackpackToCartPDP();
        pdp.navigateToCartPDP();
        pdp.verifyThatBackpackIsRemovedFromCart();
    
}


@Test

    public void verifyIfItemIsRemovedFromCartCart (){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage (driver);
        PDP pdp = new PDP (driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.navigateToPDP();
        pdp.addBackpackToCartPDP();
        pdp.navigateToCartPDP();       
        cartPage.removeItemFromCartOnCart();
        cartPage.verifyIfCartIsEmpty();
    
}
}
