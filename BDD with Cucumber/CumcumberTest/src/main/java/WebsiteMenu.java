import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebsiteMenu {
    @FindBy(xpath="(//*[normalize-space(text()) and normalize-space(.)='Welcome'])[1]/preceding::h1[1]")
    private WebElement pageTitle;


    public WebElement getPageTitle(){
        return pageTitle;
    }
    public WebElement waitForMenu(WebDriver driver){
        WebElement element = (new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[normalize-space(text()) and normalize-space(.)='Welcome'])[1]/preceding::h1[1]")));
        return element;
    }
}
