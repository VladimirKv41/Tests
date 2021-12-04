import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {
	public WebDriver driver;
    public SearchResultsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; 
    }
    
    @FindBy(id = "video-title")
    private List<WebElement> search_list;
    
    public boolean contains(String str) {
    	List<String> title_list = new ArrayList<String>();
        for (WebElement var : search_list)
        {
            title_list.add(var.getText());
        }
		return title_list.contains(str); 
    }
    public void click_title(String str){
    	List<String> title_list = new ArrayList<String>();
        for (WebElement var : search_list)
        {
            title_list.add(var.getText());
        }
        search_list.get(title_list.indexOf(str)).click();
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
