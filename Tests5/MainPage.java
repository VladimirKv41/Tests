import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    
    @FindBy(name = "search_query")
    private WebElement search;
    
    public void input_search(String login) {
    	search.sendKeys(login); 
    }
    
    @FindBy(id = "search-icon-legacy")
    private WebElement button;
    
	public void click_confirm_button(){
		button.click();
		try {
			Thread.sleep(3500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clear_search(){
		search.clear();
	}
}
