package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Lesson3 {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }

    public static void main(String[] args) throws InterruptedException {
        driver = getDriver();
        test1(driver);
        test2(driver);
        driver.quit();
    }

    public static void test1(WebDriver driver) {
        driver.get("https://diary.ru");
        WebElement input = driver.findElement(By.id("drop-login"));
        input.click();
        WebElement login = driver.findElement(By.id("usrlog2"));
        login.click();
        login.sendKeys("Denis12345");
        WebElement pass = driver.findElement(By.id("usrpass2"));
        pass.click();
        pass.sendKeys("e#dd8e78a");
        WebElement further = driver.findElement(By.xpath("//*[@id=\"loginform\"]/form/button"));
        further.click();
        WebElement drop = driver.findElement(By.id("drop"));
        drop.click();
        WebElement logoff = driver.findElement(By.linkText("Выход"));
        logoff.click();
    }

    public static void test2(WebDriver driver) {
        driver.get("https://diary.ru");
        WebElement input = driver.findElement(By.id("drop-login"));
        input.click();
        WebElement login = driver.findElement(By.id("usrlog2"));
        login.click();
        login.sendKeys("Denis12345");
        WebElement pass = driver.findElement(By.id("usrpass2"));
        pass.click();
        pass.sendKeys("e#dd8e78a");
        WebElement further = driver.findElement(By.xpath("//*[@id=\"loginform\"]/form/button"));
        further.click();
        WebElement newent = driver.findElement(By.linkText("Новая запись"));
        newent.click();
        WebElement heading = driver.findElement(By.id("postTitle"));
        heading.click();
        heading.sendKeys("Тест 2...");
        WebElement text = driver.findElement(By.id("message"));
        text.click();
        text.sendKeys("...выполняется успешно!!!");
        WebElement preview = driver.findElement(By.id("preview"));
        preview.click();
        WebElement view = driver.findElement(By.linkText("Denis12345"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(view));
        WebElement drop = driver.findElement(By.id("drop"));
        drop.click();
        WebElement logoff = driver.findElement(By.linkText("Выход"));
        logoff.click();
        driver.quit();
    }
}
