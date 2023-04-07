package tests;

import org.junit.Test;

import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    String emptyUsernameError = "Epic sadface: Username is required";
    String emptyPasswordError = "Epic sadface: Password is required";
    String lockedUser = "locked_out_user";
    String lockedUserError = "Epic sadface: Sorry, this user has been locked out.";

    @Test
    public void checkIfUserCanLogin(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.checkIfUserIsOnHomePage();
    }

    @Test
    public void validateThatUserCannotLogInWithoutUsername(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login("", password);
        loginPage.checkLoginErrorMessage(emptyUsernameError);
    }

    @Test
    public void validateThatUserCannotLogInWithoutPassword(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, "");
        loginPage.checkLoginErrorMessage(emptyPasswordError);
    }

    @Test
    public void validateThatLockedUserCannotLogIn(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(lockedUser, password);
        loginPage.checkLoginErrorMessage(lockedUserError);
    }

    @Test
    public void validateThatUserCanLogOut(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.goToBaseUrl();
        loginPage.login(username, password);
        homePage.expandMenu();
        homePage.clickOnLogoutLink();
        loginPage.verifyThatUserIsLoggedOut();
    }
    
}
