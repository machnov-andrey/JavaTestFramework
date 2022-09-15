package machnov.testFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Main {

    private WebElement RegisterButton;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();

        //WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new EdgeDriver();
        driver.get("https://vk.com/");
        driver.manage().window().maximize();
        WebElement button = driver.findElement(By.xpath("//button[contains(@class,'signUp')]"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        Thread.sleep(1000);
        js.executeScript("arguments[0].style.border='3px solid red'", button);
        Thread.sleep(1000);
        button.click();

        //driver.navigate().to("ya.ru");
        //System.out.println("Hello world!");
        Thread.sleep(5000);
        driver.quit();
    }
}