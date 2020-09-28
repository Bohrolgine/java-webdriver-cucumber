package definitions;

import cucumber.api.java.en.Given;
import pages.QUOTE.QuoteForm;
import pages.UPS.UpsHome;
import pages.USPS.UspsHome;

public class CommonStepsDefs {

    //QuoteForm form = new QuoteForm();

    @Given("I open {string} page")
    public void iOpenPage(String page) {

        switch (page) {
            case "quote":
                new QuoteForm().open();
                break;

            case "usps":
                new UspsHome().open();
                break;

            case "ups":
                new UpsHome().open();
                break;

            default:
                throw new RuntimeException("Unknown page: " + page);
        }
    }

}
