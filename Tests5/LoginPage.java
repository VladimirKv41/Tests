
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
     
    @FindBy(id = "headingText")
    private WebElement head_text;
    
    @FindBy(id = "identifierId")
    private WebElement email;
    
    @FindBy(css = ".o6cuMc")
    private WebElement email_error;
    
    @FindBy(css = ".VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.qIypjc.TrZEUc.lw1w4b")
    private WebElement button;
    
    public void input_email(String login) {
    	email.sendKeys(login); 
    }

    public String get_email_error() {;
        return email_error.getText(); 
    }
	public void click_confirm_button(){
		button.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clear_email(){
		email.clear();
	}
	
}
