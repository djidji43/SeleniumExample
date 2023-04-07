package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }

    String baseUrl = "https://www.saucedemo.com";

    By usernameBy = By.xpath("//*[@id='user-name']");
    By passwordBy = By.xpath("//*[@id='password']");
    By loginBtnBy = By.xpath("//*[@id='login-button']");
    By errorBy = By.xpath("//h3[@data-test='error']");

    //return this vraca trenutni kontekst LoginPage strane
    public LoginPage goToBaseUrl(){
        driver.get(baseUrl);
        return this;
    }

    public LoginPage login(String username, String password){
        writeText(usernameBy, username);
        writeText(passwordBy, password);
        click(loginBtnBy);
        return this;
    }

    public LoginPage checkLoginErrorMessage(String expectedText){
        String foundError = readText(errorBy);
        checkIfTextIsTheSame(expectedText, foundError);
        return this;
    }

    public LoginPage verifyThatUserIsLoggedOut(){
        checkIfElementIsVisible(loginBtnBy);
        return this;
    }
    
}
