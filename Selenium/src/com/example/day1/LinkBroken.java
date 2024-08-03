package com.example.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkBroken {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\IdeaProjects\\Selenium\\Drivers\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //JavascriptExecutor js= (JavascriptExecutor) driver;
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='firstname']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Anurag");
        driver.findElement(By.cssSelector("input[name='lastname']")).click();
        driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys("Sonu");
        driver.close();



    }
}
