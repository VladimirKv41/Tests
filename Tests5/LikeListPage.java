

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LikeListPage {
	public WebDriver driver;
    public LikeListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; 
    }
    
    @FindBy(css = ".yt-simple-endpoint.style-scope.ytd-playlist-video-renderer")
    private WebElement video_title;
    
    public String get_video_title() {
    	return video_title.getText(); 
    }
}
