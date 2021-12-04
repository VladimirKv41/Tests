import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsChrome {
	public static LoginPage login_page;
    public static PasswordPage password_page;
    public static MainPage main_page;
    public static NoSearchResultsPage noresults_page;
    public static SearchResultsPage results_page;
    public static VideoPage video_page;
    public static LikeListPage like_list_page;
    public static WebDriver driver;
    
	@BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "D:/EdgeDownload/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2F"
        		+ "www.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Dru%26next%3D"
        		+ "https%253A%252F%252Fwww.youtube.com%252F&hl=ru&service="
        		+ "youtube&flowName=GlifWebSignIn&flowEntry=ServiceLogin"); 
        login_page = new LoginPage(driver);
        password_page = new PasswordPage(driver);
        main_page = new MainPage(driver);
        noresults_page = new NoSearchResultsPage(driver);
        results_page = new SearchResultsPage(driver);
        video_page = new VideoPage(driver);
        like_list_page = new LikeListPage(driver);
        login_page.input_email("vladimirkovalev19076@gmail.com");
    	login_page.click_confirm_button();
    	password_page.input_password("test_190766");
    	password_page.click_confirm_button();
    	driver.manage().window().maximize();
    }
	@Test
    public void search_true() {
    	main_page.input_search("Wildlife in the Forest - Live Camera with sound || fox, badger, marten, deer and birds - Denmark");
    	main_page.click_confirm_button();
    	main_page.clear_search();
        Assert.assertEquals(results_page.contains("Wildlife in the Forest - Live Camera with sound || fox, badger, marten, deer and birds - Denmark"), true);
    }
	@Test
    public void like() {
    	main_page.input_search("Wildlife in the Forest - Live Camera with sound || fox, badger, marten, deer and birds - Denmark");
    	main_page.click_confirm_button();
    	main_page.clear_search();
    	results_page.click_title("Wildlife in the Forest - Live Camera with sound || fox, badger, marten, deer and birds - Denmark");
    	video_page.click_like_button();
    	video_page.click_guide_button();
    	video_page.click_like_list_button();
        Assert.assertEquals(like_list_page.get_video_title(), "Wildlife in the Forest - Live Camera with sound || fox, badger, marten, deer and birds - Denmark");
        main_page.input_search("Wildlife in the Forest - Live Camera with sound || fox, badger, marten, deer and birds - Denmark");
        main_page.click_confirm_button();
        main_page.clear_search();
        results_page.click_title("Wildlife in the Forest - Live Camera with sound || fox, badger, marten, deer and birds - Denmark");
    	video_page.click_like_button();
    }
	@Test
    public void search_wrong() {
    	main_page.input_search("((($!$)!$#$");
    	main_page.click_confirm_button();
    	main_page.clear_search();
        Assert.assertEquals(noresults_page.get_search_error(), "Результатов не найдено");
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();   
    }
}
