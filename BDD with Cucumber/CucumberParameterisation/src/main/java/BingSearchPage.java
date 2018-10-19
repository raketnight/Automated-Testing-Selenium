import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BingSearchPage {
    @FindBy(id = "sb_form_q")
    private WebElement searchBox;

    public void enterIntoSearchBox(String searchTerm){
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }
}
