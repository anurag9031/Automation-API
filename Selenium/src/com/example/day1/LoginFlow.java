package com.example.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class LoginFlow {

    public static void main(String[] args) {

        String url="";

        System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\IdeaProjects\\Selenium\\Drivers\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("txtUsername")).click();
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).click();
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        List < WebElement> link = driver.findElements(By.tagName("a"));
        Iterator<WebElement> it= link.iterator();
        while(it.hasNext()) {

            url = it.next().getAttribute("href");

            System.out.println(url);

        }


    }


}
