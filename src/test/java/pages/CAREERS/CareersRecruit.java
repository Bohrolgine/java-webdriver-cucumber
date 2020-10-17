package pages.CAREERS;

import cucumber.api.java8.Th;
import definitions.Careers;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static support.TestContext.getWait;

public class CareersRecruit extends CareersHeader{


    public CareersRecruit() {
        url = "https://skryabin-careers.herokuapp.com/recruit";
    }

    @Override
    public void refresh() {
        new CareersHome().open();
        open();
        try {
            Thread.sleep(500); }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }




    // dynamic element

    private WebElement positionCard(String title) {
        return getByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card-body')]");
    }

    private List<WebElement> allPositionCards(String title) {
        return getAllByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card')]//button");
    }

    private WebElement closeForPosition(String title) {
        return getByXpath("//h4[text()='" + title + "']/ancestor::div[contains(@class,'card')]//button");
    }


    public boolean isPositionVisible(String title) {
//        List<WebElement> cards = allPositionCards(title);
//        if (cards.isEmpty()) {
//            return false;
//        } else {
//            return cards.get(0).isDisplayed();
//        }

        try {
            return positionCard(title).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }



    public CareersRecruit removePosition(String title) throws InterruptedException {
        WebElement card = positionCard(title);
        WebElement closeButton = closeForPosition(title);

        mouseOver(card);
        waitForClickable(closeButton);
        //Thread.sleep(3000);
        click(closeButton);
        //getWait().until(ExpectedConditions.invisibilityOf(card));
        waitForDisappear(card);

        return new CareersRecruit();
    }

}

