import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VideoPage {
	public WebDriver driver;
    public VideoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; 
    }
    
    @FindBy(css = ".style-scope.ytd-toggle-button-renderer.style-text")
    private List<WebElement> buttons_ld;
    
    @FindBy(id = "guide-button")
    private WebElement guide_button;
    
    @FindBy(xpath = "//*[@title='Понравившиеся']")
    private WebElement button_like_list;
    
    public void click_like_button(){
		buttons_ld.get(0).click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    public void click_guide_button(){
    	guide_button.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    public void click_like_list_button(){
		button_like_list.click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
