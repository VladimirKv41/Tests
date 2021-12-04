import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestsRegistFirefox {

	public static RegistrationPage regist_page;
    public static RegistrationConfirmPage regist_confirm_page;
    public static LoginPage login_page;
    public static PasswordPage password_page;
    public static WebDriver driver;
    
    
    @SuppressWarnings("deprecation")
	@BeforeClass
    public static void setup_registration() {
        System.setProperty("webdriver.gecko.driver", "D:/EdgeDownload/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(
        		"https://accounts.google.com/signup/v2/webcreateaccount?service="
        		+ "youtube&continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3"
        		+ "Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Dru%26next%3Dhttps%253A%252F%252F"
        		+ "www.youtube.com%252F&hl=ru&dsh=S1174946317%3A1637164420369632&biz=false&flow"
        		+ "Name=GlifWebSignIn&flowEntry=SignUp&nogm=true"); 
        regist_page = new RegistrationPage(driver);
        regist_confirm_page = new RegistrationConfirmPage(driver);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(
        		By.xpath("//*[contains(.,'Создать вместо этого адрес электронной почты в Gmail')]"))).click();
        driver.manage().window().maximize();
     } 
	@Test
    public void regitstration_true() {
    	regist_page.input_first_name("vladimir");
    	regist_page.input_last_name("kovalev");
		regist_page.input_login("vladimirkovalev19077");
		regist_page.input_password("test_190766");
		regist_page.input_confirm_password("test_190766");
        regist_page.click_confirm_button();
        Assert.assertEquals(regist_confirm_page.getText(), "Подтвердите номер телефона");
        driver.get("https://accounts.google.com/signup/v2/webcreateaccount?service="
        		+ "youtube&continue=https%3A%2F%2Fwww.youtube.com%2Fsignin%3"
        		+ "Faction_handle_signin%3Dtrue%26app%3Ddesktop%26hl%3Dru%26next%3Dhttps%253A%252F%252F"
        		+ "www.youtube.com%252F&hl=ru&dsh=S1174946317%3A1637164420369632&biz=false&flow"
        		+ "Name=GlifWebSignIn&flowEntry=SignUp&nogm=true");
    }
	@Test
    public void registration_null() {
    	regist_page.input_first_name("");
    	regist_page.input_last_name("");
		regist_page.input_login("");
		regist_page.input_password("");
		regist_page.input_confirm_password("");
        regist_page.click_confirm_button();
        Assert.assertEquals(regist_page.get_name_error(), "Введите имя и фамилию");
        Assert.assertEquals(regist_page.get_username_error(), "Укажите адрес Gmail");
        Assert.assertEquals(regist_page.get_password_error(), "Введите пароль");
        regist_page.clear_forms();
    }
	@Test
    public void registration_login_wrong() {
    	regist_page.input_first_name("vladimir");
    	regist_page.input_last_name("kovalev");
		regist_page.input_login("124###");
		regist_page.input_password("test_190766");
		regist_page.input_confirm_password("test_190766");
        regist_page.click_confirm_button();
        Assert.assertEquals(regist_page.get_username_error(), 
        		"Имя пользователя может включать латинские буквы (a-z), цифры (0-9) и точку (.).");
        regist_page.clear_forms();
    }
	@Test
    public void registration_password_wrong() {
    	regist_page.input_first_name("vladimir");
    	regist_page.input_last_name("kovalev");
		regist_page.input_login("vladimirkovalev19077");
		regist_page.input_password("124###");
		regist_page.input_confirm_password("test_190766");
        regist_page.click_confirm_button();
        Assert.assertEquals(regist_page.get_password_error(), "Пароль не может быть короче 8 символов");
        regist_page.clear_forms();
    }
	@Test
    public void registration_confirm_password_wrong() {
    	regist_page.input_first_name("vladimir");
    	regist_page.input_last_name("kovalev");
		regist_page.input_login("vladimirkovalev19077");
		regist_page.input_password("test_190766");
		regist_page.input_confirm_password("124###");
        regist_page.click_confirm_button();
        Assert.assertEquals(regist_page.get_password_error(), "Пароли не совпадают. Повторите попытку.");
        regist_page.clear_forms();
    }
	@Test
    public void registration_first_name_null() {
    	regist_page.input_first_name("");
    	regist_page.input_last_name("kovalev");
		regist_page.input_login("vladimirkovalev19077");
		regist_page.input_password("test_190766");
		regist_page.input_confirm_password("test_190766");
        regist_page.click_confirm_button();
        Assert.assertEquals(regist_page.get_name_error(), "Укажите имя");
        regist_page.clear_forms();
    }
	@Test
    public void registration_last_name_null() {
    	regist_page.input_first_name("vladimir");
    	regist_page.input_last_name("");
		regist_page.input_login("vladimirkovalev19077");
		regist_page.input_password("test_190766");
		regist_page.input_confirm_password("test_190766");
        regist_page.click_confirm_button();
        Assert.assertEquals(regist_page.get_name_error(), "Укажите фамилию");
        regist_page.clear_forms();
    }
	@Test
    public void registration_login_null() {
    	regist_page.input_first_name("vladimir");
    	regist_page.input_last_name("kovalev");
		regist_page.input_login("");
		regist_page.input_password("test_190766");
		regist_page.input_confirm_password("test_190766");
        regist_page.click_confirm_button();
        Assert.assertEquals(regist_page.get_username_error(), "Укажите адрес Gmail");
        regist_page.clear_forms();
    }
	@Test
    public void registration_password_null() {
    	regist_page.input_first_name("vladimir");
    	regist_page.input_last_name("kovalev");
		regist_page.input_login("vladimirkovalev19077");
		regist_page.input_password("");
		regist_page.input_confirm_password("test_190766");
        regist_page.click_confirm_button();
        Assert.assertEquals(regist_page.get_password_error(), "Введите пароль");
        regist_page.clear_forms();
    }
	@Test
    public void registration_confirm_password_null() {
    	regist_page.input_first_name("vladimir");
    	regist_page.input_last_name("kovalev");
		regist_page.input_login("vladimirkovalev19077");
		regist_page.input_password("test_190766");
		regist_page.input_confirm_password("");
        regist_page.click_confirm_button();
        Assert.assertEquals(regist_page.get_password_error(), "Подтвердите пароль");
        regist_page.clear_forms();
    }
    @AfterClass
    public static void tearDown_registration() {
        driver.quit();   
    }

}

