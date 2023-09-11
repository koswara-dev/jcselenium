package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OrangeHRM {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        // waiting element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Open Browser, Open URL");

        // Login
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(@class, 'login-button')]"));
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        btnLogin.click();
        // Dashboard
        WebElement txtDashboard = driver.findElement(By.xpath("//h6[contains(@class, 'topbar-header-breadcrumb')]"));
        System.out.println(txtDashboard.getText());
        WebElement profileDropdown = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
        profileDropdown.click();
        WebElement logout = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
        logout.click();
        // Navigation Back
        driver.navigate().back();
        // List : ada berapa tag input
        delay(5);
//        List<WebElement> listInput = driver.findElements(By.xpath("//input"));
//        System.out.println(listInput.size());
//        listInput.get(1).sendKeys("Admin");
//        System.out.println("Input Username");

        // Test Case Negative pada Login
        username.sendKeys("Adminn");
        password.sendKeys("admin1234");
        btnLogin.click();

        System.out.println("Test Case Negative pada Login");


        // Buat Assert menggunakan if
//        if(titlePage.equals("Text Box")){
//            System.out.println("Result Testing Pass");
//        } else {
//            System.out.println("Result Testing Fail");
//        }


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

    // buatkan method custom assert
}
