package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import static support.TestContext.getDriver;

public class QuoteResult extends Page{

//    public QuoteResult() {
//        PageFactory.initElements(getDriver(), this);
//    }

    @FindBy(id = "quotePageResult")
    private WebElement result;

    @FindBy(xpath = "//b[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//b[@name='agreedToPrivacyPolicy']")
    private WebElement agreedToPrivacyPolicy;

    @FindBy(xpath = "//b[@name='allowedToContact']")
    private WebElement allowedToContact;

    public String getResultText() {
        return result.getText();
    }

    public boolean isAgreedToPrivacyPolicy() {
        return Boolean.parseBoolean(agreedToPrivacyPolicy.getText());
        //String agreedText = agreedToPrivacyPolicy.getText();
        //return Boolean.parseBoolean(agreedText);
        //return agreedToPrivacyPolicy.getText().equals("true");
    }

    public boolean isAllowedToContact() {
        return Boolean.parseBoolean(allowedToContact.getText());
    }

    public String getPasswordText() {
        return password.getText();
    }
}
