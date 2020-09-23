package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import static support.TestContext.getWait;

public class QuoteForm extends Page {


    //constructor
    public QuoteForm() {
        PageFactory.initElements(getDriver(), this);
        url = "https://skryabin.com/market/quote.html";
        title = "Get a Quote";
    }

    // selectors
    @FindBy(xpath = "//input[@name='username']")            private WebElement username;
    @FindBy(name = "email")                                 private WebElement email;
    @FindBy(xpath = "//input[@id='password']")              private WebElement password;
    @FindBy(xpath = "//input[@id='confirmPassword']")       private WebElement confirmPassword;
    @FindBy(xpath = "//input[@name='name']")                private WebElement name;

    //name dialog
    @FindBy(xpath = "//input[@id='firstName']")             private WebElement firstName;
    @FindBy(xpath = "//input[@id='middleName']")            private WebElement middleName;
    @FindBy(xpath = "//input[@id='lastName']")              private WebElement lastName;
    @FindBy(xpath = "//span[text()='Save']")                private WebElement saveButton;
    @FindBy(name = "agreedToPrivacyPolicy")                 private WebElement privacy;
    @FindBy(name = "formSubmit")                            private WebElement submit;

    //additional info iFrame
    @FindBy(name = "additionalInfo")                        private WebElement additionalInfoFrame;
    @FindBy(id = "contactPersonName")                       private WebElement contactPersonName;
    @FindBy(id = "contactPersonPhone")                      private WebElement contactPersonPhone;

    //errors
    @FindBy(id = "username-error")                          private WebElement usernameError;
    @FindBy(id = "email-error")                             private WebElement emailError;
    @FindBy(id = "password-error")                          private WebElement passwordError;
    @FindBy(xpath = "//label[@id='confirmPassword-error']") private WebElement confirmPasswordError;
    @FindBy(id = "name-error")                              private WebElement nameError;
    @FindBy(id = "agreedToPrivacyPolicy-error")             private WebElement policyError;


    // methods - error messages
    public String getUsernameErrorText()                    { return usernameError.getText(); }
    public String getEmailErrorText()                       { return emailError.getText(); }
    public String getPasswordErrorText()                    { return passwordError.getText(); }
    public String getConfirmPasswordErrorText()             { return confirmPasswordError.getText(); }
    public String getNameErrorText()                        { return nameError.getText(); }
    public String getagreedToPrivacyPolicyErrorText()       { return policyError.getText(); }




    public void fillContactInfo(String nameValue, String phoneValue) {

        getDriver().switchTo().frame(additionalInfoFrame);

        contactPersonName.sendKeys(nameValue);
        contactPersonPhone.sendKeys(phoneValue);

        getDriver().switchTo().defaultContent();
    }

    public void fillUsername(String value)              { username.sendKeys(value); }
    public void fillEmail(String value)                 { email.sendKeys(value); }
    public void fillBothPasswords(String value)         { password.sendKeys(value); confirmPassword.sendKeys(value); }
    public void fillPassword(String value)              { password.clear(); password.sendKeys(value); }
    public void fillPasswordConfirm(String value)       { confirmPassword.clear(); confirmPassword.sendKeys(value); }


    public void fillName(String firstNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();

        String nameValue = name.getAttribute("value");
        assertThat(nameValue).isEqualTo(firstNameValue + " " + lastNameValue);
    }

    public void fillName(String firstNameValue, String middleNameValue, String lastNameValue) {
        name.click();
        firstName.sendKeys(firstNameValue);
        middleName.sendKeys(middleNameValue);
        lastName.sendKeys(lastNameValue);
        saveButton.click();
        assertThat(name.getAttribute("value")).isEqualTo(firstNameValue + " " + middleNameValue + " " + lastNameValue);
    }


    public void agreeWithPrivacyPolicy() {
        if (!privacy.isSelected()) {
            privacy.click();
        }
    }

    public void submit() {
        submit.click();
    }

    public String getElementText(String str) {
        switch (str) {
            case "name":
                getWait(25).until(ExpectedConditions.visibilityOf(name));
                return this.name.getAttribute("value");
            default:
                throw new RuntimeException("Unknown WebElement: " + str);
        }
    }



}

