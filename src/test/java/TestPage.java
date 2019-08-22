import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class TestPage {
    private WebDriver driver;


    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp()  {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com");
      //  driver.navigate().to("https://ru.wikipedia.org");

    }

    @After
    public void tearDown()  {
        // Закрываем браузер
        // driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    @Test
    public void name()   {
        HomePage home = new HomePage(driver);

        String res="Кошка";

        try {
            String utf8String= new String(res.getBytes("windows-1251"),"UTF-8" );home.search(utf8String);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 not supported");
        }



        System.out.println("file.encoding=" + System.getProperty("file.encoding"));
        System.out.println("Charset.defaultCharset=" + Charset.defaultCharset());

    }
}
