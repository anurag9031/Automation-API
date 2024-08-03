package com.example.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.datatransfer.StringSelection;

public class Robot {

    public static void main(String[] args) throws InterruptedException {

        WebElement browse;
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\IdeaProjects\\Selenium\\Drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://my.monsterindia.com/create_account.html");
        //StringSelection StringSelection = new StringSelection("/Users/priyanka.a/Downloads/SeleniumDemo/test.txt");
        //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(StringSelection, null);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //WebElement alert=driver.findElement(By.xpath("//div[@class='wzrk-alert wiz-show-animate']//div//button[contains(.,'No Thanks')]"));
        //js.executeScript("arguments[0].click();",alert);

        WebElement label=driver.findElement(By.xpath("//label//h3[contains(.,'Upload')]"));

        //  actions.moveToElement(label).build().perform();
        js.executeScript("arguments[0].click();", label);
        WebElement el= driver.findElement(By.xpath("//label[@for='file-upload']"));
      //  driver.findElement(By.id("file-upload")).sendKeys("/Users/priyanka.a/SeleniumMay/src/com/example/day1/resume.txt");
        Thread.sleep(2000);
    }
}
