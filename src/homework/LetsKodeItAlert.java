package homework;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.WebElement.*;

public class LetsKodeItAlert {

    private WebDriver driver;
    private String baseUrl = "https://learn.letskodeit.com/";
    private JavascriptExecutor js;
    private WebElement practiceLink;


    @Test
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver1.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        driver = new ChromeDriver(options);
        js = (JavascriptExecutor) driver;
        driver.manage().window().setPosition(new Point(-2000, 0));//display2
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @Test
    public void okAlert() throws InterruptedException {
        practiceLink=driver.findElement(By.linkText("Practice"));
        practiceLink.click();
        //to scroll to page down
        js.executeScript("window.scrollBy(0,-1800);");
        Thread.sleep(3000);
        WebElement alertLink=driver.findElement(By.id("alertbtn"));
        alertLink.click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
    @After
    public void closeBrowser(){
        driver.quit();
    }
}
