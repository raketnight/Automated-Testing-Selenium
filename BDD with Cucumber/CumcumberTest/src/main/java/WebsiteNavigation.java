import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebsiteNavigation {
    @FindBy(linkText = "Menu")
    private WebElement menu;

    @FindBy(linkText = "Check Out")
    private WebElement checkout;

    public void goToMenu(){
        menu.click();
    }
    public void goToCheckout(){
        checkout.click();
    }
}
