import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Step {
    private WebDriver driver;
    String pageTitle = null;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.close();
    }

    @Given("^I go to \"([^\"]*)\" website$")
    public void i_go_to_website(String arg1) throws Throwable {
        driver.get(arg1);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void i_search_for(String arg1) throws Throwable {
        BingSearchPage bingSearchPage = PageFactory.initElements(driver,BingSearchPage.class);
        bingSearchPage.enterIntoSearchBox(arg1);
        pageTitle = arg1 + " - Bing";

    }

    @Then("^I am taken to a list of data for that search$")
    public void i_am_taken_to_a_list_of_data_for_that_search() throws Throwable {
        String currentTitle = driver.getTitle();
        Assert.assertEquals(currentTitle, pageTitle );
    }
}
