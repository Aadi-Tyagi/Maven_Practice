package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class TC_Login2 {

    @Test
    public void login_Test() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://opensource-demo.orangehrmlive.com/");

        wait.until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys("Admin");
        wait.until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys("admin123");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type= \"submit\"]"))).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");


        driver.close();

    }
}
