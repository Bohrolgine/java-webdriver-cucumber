package pages.CAREERS;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class CareersLogin extends CareersHeader {

    //label[@for='loginUsername']/following-sibling::input"
    //"//label[@for='loginUsername']/ancestor::div[@class='container']"
    @FindBy(xpath = "//label[@for='loginUsername']/../input")
    private WebElement username;

    @FindBy(xpath = "//label[@for='loginPassword']/../input")
    private WebElement password;

    @FindBy(id = "loginButton")
    private WebElement login;




    public CareersHome login(String usernameValue, String passwordValue){
        sendKeys(username, usernameValue);
        sendKeys(password, passwordValue);
        click(login);
        return new CareersHome();
    }

}
