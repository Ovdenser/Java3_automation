package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class App {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://.google.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement input = driver.findElement(By.cssSelector("input[title='Поиск']"));
        input.click();
        input.sendKeys("github");
        input.sendKeys(Keys.ENTER);

//        String.wikiLink = "https://ru.wikipedia.org/wiki/GitHub";
        WebElement wikiLink = driver.findElement(By.linkText("Википедия"));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(wikiLink));
        String wikiLinkString = wikiLink.getCssValue("href");
        wikiLink.click();
        System.out.println(wikiLinkString);
        List<WebElement> divElements = driver.findElements(By.tagName("shlyapa"));
        if (divElements.size() == 0) {
            driver.quit();
            throw new NoSuchElementException("0 elements found");
        }
        System.out.println(divElements.size());
        driver.quit();
    }
}



