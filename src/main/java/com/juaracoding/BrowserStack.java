package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserStack {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com");
        // waiting element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser, Open URL");

        Actions actions = new Actions(driver);
//        WebElement btnGetStarted = driver.findElement(By.xpath("//a[@id='signupModalButton']"));
//        actions.moveToElement(btnGetStarted).click().perform();

//        WebElement btnMenuProduct = driver.findElement(By.xpath("//*[@id=\"product-nav\"]/ul/li[1]"));
//        actions.moveToElement(btnMenuProduct).perform(); // Mouse Hover

        // Gunakan List pada Menu BrowserStack
        // tampilkan / getText ke console
        delay(5);
        List<WebElement> listMenuBS = driver.findElements(By.xpath("//*[@id=\"product-nav\"]/ul/li"));
        System.out.println(listMenuBS.size());
        for (WebElement menuBS : listMenuBS) {
            System.out.println(menuBS.getText());
        }

        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
