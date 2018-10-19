import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Pa;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Stepper {
    private WebDriver driver;
    ExtentReports extentReports = new ExtentReports(Constants.reportSaveLocation,true);
    ExtentTest scenario1; ExtentTest scenario2;


    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        scenario1 = extentReports.startTest("Starting Scenario 1");
        scenario2 = extentReports.startTest("Starting scenario 2");
    }

    @After
    public void tearDown(){
        driver.quit();
        extentReports.flush();
    }

    @Given("^the correct web address$")
    public void the_correct_web_address() throws Throwable {

        driver.get(Constants.teaWebsite);
        scenario1.log(LogStatus.INFO, "Loaded onto the correct website");
        scenario2.log(LogStatus.INFO, "Loaded onto the correct website");
    }

    @When("^I navigate to the 'Menu' page$")
    public void i_navigate_to_the_Menu_page() throws Throwable {
        WebsiteNavigation websiteNavigation = PageFactory.initElements(driver,WebsiteNavigation.class);
        WebsiteMenu websiteMenu = PageFactory.initElements(driver, WebsiteMenu.class);
        websiteNavigation.goToMenu();
        if(websiteMenu.getPageTitle().getText().equals("Menu")){
            scenario1.log(LogStatus.PASS, "Navigated successfully to the Menu page");
        }
        else{
            scenario1.log(LogStatus.FAIL, "Could not navigate to the Menu page");
        }
        Assert.assertEquals("Menu", websiteMenu.waitForMenu(driver).getText());

    }

    @Then("^I can browse a list of the available products\\.$")
    public void i_can_browse_a_list_of_the_available_products() throws Throwable {
        WebsiteMenu websiteMenu = PageFactory.initElements(driver, WebsiteMenu.class);
        Assert.assertEquals("Menu", websiteMenu.getPageTitle().getText());
        scenario1.log(LogStatus.INFO, "Can see list of items to buy on the Menu page");
    }

    @When("^I click the checkout button$")
    public void i_click_the_checkout_button() throws Throwable {
        WebsiteNavigation websiteNavigation = PageFactory.initElements(driver, WebsiteNavigation.class);
        websiteNavigation.goToCheckout();
        scenario2.log(LogStatus.INFO, " Check out button has been clicked");
    }

    @Then("^I am taken to the checkout page$")
    public void i_am_taken_to_the_checkout_page() throws Throwable {
        WebsiteCheckout websiteCheckout = PageFactory.initElements(driver, WebsiteCheckout.class);
        Assert.assertEquals("Pay with Credit Card or Log In", websiteCheckout.getPageTitle().getText());
        if(websiteCheckout.getPageTitle().getText().equals("Pay with Credit Card or Log In")){
            scenario2.log(LogStatus.PASS, "Navigated successfully to the checkout page");
        }
        else {
            scenario2.log(LogStatus.FAIL, "Could not navigate to the checkout page");
        }
    }
}
