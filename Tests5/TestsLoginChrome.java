
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestsLoginChrome {
	public static LoginPage login_page;
    public static PasswordPage password_page;
    public static WebDriver driver;
    
	@Before
    public void setup_login() {
        System.setProperty("webdriver.chrome.driver", "D:/EdgeDownload/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2F"
        		+ "www.youtube.com%2Fsignin%3Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Dru%26next%3D"
        		+ "https%253A%252F%252Fwww.youtube.com%252F&hl=ru&service="
        		+ "youtube&flowName=GlifWebSignIn&flowEntry=ServiceLogin"); 
        login_page = new LoginPage(driver);
        password_page = new PasswordPage(driver);
        driver.manage().window().maximize();
    }
    @Test
    public void login_true() {
    	login_page.input_email("vladimirkovalev19076@gmail.com");
    	login_page.click_confirm_button();
        Assert.assertEquals(password_page.get_head_text(), "Äîáðî ïîæàëîâàòü!"); 
    }
    @Test
    public void login_null() {
    	login_page.input_email("");
    	login_page.click_confirm_button();
        Assert.assertEquals(login_page.get_email_error(), "Ââåäèòå àäðåñ ýëåêòðîííîé ïî÷òû èëè íîìåð òåëåôîíà."); 
    }
    @Test
    public void login_wrong() {
    	login_page.input_email("@");
    	login_page.click_confirm_button();
        Assert.assertEquals(login_page.get_email_error(), "Ââåäèòå àäðåñ ýëåêòðîííîé ïî÷òû èëè íîìåð òåëåôîíà."); 
    }
    @Test
    public void login_random() {
    	login_page.input_email("fdsfwae123`1");
    	login_page.click_confirm_button();
    	boolean bool_temp = true;
    	try {
    		driver.findElement(By.id("ca"));
		} catch (NoSuchElementException e) {			
			bool_temp = false;
		}
    	if(bool_temp)
    		Assert.assertTrue(bool_temp);
    	else 
    		Assert.assertEquals(login_page.get_email_error(), "Íå óäàëîñü íàéòè àêêàóíò Google.");
    }
    @Test
    public void password_true() {
    	login_page.input_email("vladimirkovalev19076@gmail.com");
    	login_page.click_confirm_button();
    	password_page.input_password("test_190766");
    	password_page.click_confirm_button();
    	boolean bool = true;
    	try {
    		driver.findElement(By.id("search"));
		} catch (NoSuchElementException e) {			
			bool = false;
		}
        Assert.assertEquals(true, bool); 
    }
    @Test
    public void password_null() {
    	login_page.input_email("vladimirkovalev19076@gmail.com");
    	login_page.click_confirm_button();
    	password_page.input_password("");
    	password_page.click_confirm_button();
    	boolean bool = true;
    	try {
    		driver.findElement(By.id("search"));
		} catch (NoSuchElementException e) {
			bool = false;
		}
        Assert.assertEquals(false, bool); 
        Assert.assertEquals(password_page.get_password_error(), "Ââåäèòå ïàðîëü");
    }
    @Test
    public void password_wrong() {
    	login_page.input_email("vladimirkovalev19076@gmail.com");
    	login_page.click_confirm_button();
    	password_page.input_password("test");
    	password_page.click_confirm_button();
    	boolean bool = true;
    	try {
    		driver.findElement(By.id("search"));
		} catch (NoSuchElementException e) {
			bool = false;
		}
        Assert.assertEquals(false, bool); 
        Assert.assertEquals(password_page.get_password_error(), "Íåâåðíûé ïàðîëü. Ïîâòîðèòå ïîïûòêó èëè íàæìèòå íà ññûëêó \"Çàáûëè ïàðîëü?\", ÷òîáû ñáðîñèòü åãî.");
    }
    @After
    public void tearDown_login() {
        driver.quit();   
    }
}
