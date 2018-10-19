import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebsiteCheckout {
    @FindBy(xpath="(.//*[normalize-space(text()) and normalize-space(.)='​Enter your billing information'])[1]/following::p[1]")
    private WebElement pageTitle;

    public WebElement getPageTitle(){
        return pageTitle;
    }
}
