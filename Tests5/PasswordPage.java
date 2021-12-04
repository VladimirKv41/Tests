
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage {
	public WebDriver driver;
    public PasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
     
    @FindBy(id = "headingText")
    private WebElement head_text;
    
    @FindBy(name = "password")
    private WebElement password;
    
    @FindBy(css = ".OyEIQ.uSvLId")
    private WebElement password_error;
    
    @FindBy(css = ".VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.qIypjc.TrZEUc.lw1w4b")
    private WebElement button;
    
    public void input_password(String login) {
    	password.sendKeys(login); 
    }
    public String get_head_text() {
        return head_text.getText(); 
    }
    public String get_password_error() {;
        return password_error.getText(); 
    }
	public void click_confirm_button(){
		button.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
}
