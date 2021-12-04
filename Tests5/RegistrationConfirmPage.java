import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationConfirmPage {
	public WebDriver driver;
    public RegistrationConfirmPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    
    @FindBy(id = "headingText")
    private WebElement text;
    public String getText() {
        String string = text.getText();
        return string; 
    }
}