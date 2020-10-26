package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CAREERS.CareersHome;
import pages.CAREERS.CareersLogin;
import pages.CAREERS.CareersRecruit;
import support.Loggable;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getData;

public class Careers implements Loggable {
    @And("I login as {string}")
    public void iLoginAs(String role) throws InterruptedException {
        Map<String, String> user = getData(role);
        new CareersHome()
                .clickLogin()
                .login(user.get("email"), user.get("password"));
        Thread.sleep(3000);
    }

    @Then("I verify {string} login")
    public void iVerifyLogin(String role) {
    String expectedName = getData(role).get("name");
    String actualName = new CareersHome().getLoggedUserName();
    assertThat(actualName).isEqualTo(expectedName);
    }

    @When("I remove {string} position")
    public void iRemovePosition(String title) throws InterruptedException {
        new CareersHome().clickRecruit()
                .removePosition(title);
        Thread.sleep(2000);
    }

    @And("I verify {string} position is removed")
    public void iVerifyPositionIsRemoved(String title) throws InterruptedException {
        new CareersRecruit().refresh();
        Thread.sleep(5000);
        boolean isVisible = new CareersRecruit().isPositionVisible(title);
        boolean errorsPresent = new CareersRecruit().areErrorsPresent();
        assertThat(errorsPresent).isFalse();
        assertThat(isVisible).isFalse();

    }
}
