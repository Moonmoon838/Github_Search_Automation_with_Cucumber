package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import pages.HomePage;
import setup.Setup;

public class SearchNavigationSteps extends Setup {
    HomePage homepage;

    @Given("User visit on the Github site")
    public void user_visit_on_the_github_site() {
        driver.get("https://github.com");
    }
    @When("User search for {string} from the landing page")
    public void user_search_for_from_the_landing_page(String searchTerm) throws InterruptedException {
        homepage = new HomePage(driver);
        homepage.doSearch(searchTerm);
    }
    @Then("User verify with {string}")
    public void user_verify_with(String searchResult) throws InterruptedException {
        homepage = new HomePage(driver);
        Thread.sleep(2000);
        String resultActual = homepage.repoResultField.get(0).getText();
        Assert.assertTrue(resultActual.contains(searchResult));
    }
    @When("User click on the About button in the landing page footer")
    public void user_click_on_the_about_button_in_the_landing_page_footer() throws InterruptedException{
        homepage = new HomePage(driver);
        homepage.doClick();
    }
    @Then("User verify the About page")
    public void user_verify_the_about_page() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("about"));
    }

}
