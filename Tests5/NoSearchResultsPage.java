import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NoSearchResultsPage {
	public WebDriver driver;
    public NoSearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    
    @FindBy(css = ".promo-title.style-scope.ytd-background-promo-renderer")
    private WebElement search_error;
    
    public String get_search_error() {;
    	return search_error.getText(); 
    }
}
