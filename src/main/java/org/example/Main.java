package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    private WebElement RegisterButton;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
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
        Thread.sleep(10000);
        driver.quit();
    }
}