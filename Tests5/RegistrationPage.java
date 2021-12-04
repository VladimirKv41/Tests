import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	public WebDriver driver;
    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    
    @FindBy(id = "firstName")
    private WebElement first_name;
    
    @FindBy(id = "lastName")
    private WebElement last_name;
    
    @FindBy(id = "nameError")
    private WebElement name_error;
    
    @FindBy(id = "username")
    private WebElement username;
    
    @FindBy(css = ".o6cuMc")
    private WebElement username_error;
    
    @FindBy(name = "Passwd")
    private WebElement password;
    
    @FindBy(name = "ConfirmPasswd")
    private WebElement conf_password;
    
    @FindBy(css = ".OyEIQ.uSvLId")
    private List<WebElement> password_error;
    
    @FindBy(css = ".VfPpkd-LgbsSe.VfPpkd-LgbsSe-OWXEXe-k8QpJ.VfPpkd-LgbsSe-OWXEXe-dgl2Hf.nCP5yc.AjY5Oe.DuMIQc.qIypjc.TrZEUc.lw1w4b")
    private WebElement button;
    
    
    public void input_first_name(String login) {
    	first_name.sendKeys(login); 
    }
    public void input_last_name(String login) {
    	last_name.sendKeys(login); 
    }
    public void input_login(String login) {
    	username.sendKeys(login); 
    }
    public void input_password(String login) {
    	password.sendKeys(login); 
    }
    public void input_confirm_password(String login) {
    	conf_password.sendKeys(login); 
    }

    public String get_name_error() {;
        return name_error.getText(); 
    }
    public String get_username_error() {
        return username_error.getText(); 
    }
    public String get_password_error() {
        return password_error.get(1).getText(); 
    }
	public void click_confirm_button(){
		button.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void clear_forms(){
		first_name.clear();
		last_name.clear();
		username.clear();
		password.clear();
		conf_password.clear();
	}
    
}
