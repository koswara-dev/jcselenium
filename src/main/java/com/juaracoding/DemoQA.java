package com.juaracoding;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DemoQA {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",path);
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
        // waiting element
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        System.out.println("Open Browser, Open URL");

        String titlePage = driver.findElement(By.className("main-header")).getText(); // scraping
        System.out.println(titlePage);
        String titleHeader = driver.getTitle();
        System.out.println(titleHeader);
        driver.findElement(By.id("userName")).sendKeys("JuaraCoding");
        driver.findElement(By.id("userEmail")).sendKeys("info@juaracoding.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Jakarta");
        driver.findElement(By.id("permanentAddress")).sendKeys("Jakarta");
        js.executeScript("window.scrollBy(0,500)"); // scroll vertical 500px
        driver.findElement(By.id("submit")).click();

        // Buat Assert menggunakan if
        if(titlePage.equals("Text Box")){
            System.out.println("Result Testing Pass");
        } else {
            System.out.println("Result Testing Fail");
        }


        delay();
        driver.quit();
        System.out.println("Quit Browser");
    }

    static void delay(){
        try {
            Thread.sleep(3000); // Delay 3 detik
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
