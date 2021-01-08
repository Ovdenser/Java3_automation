package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class AppTest {
    public static WebDriver driver;
    public final String WIKILINK = "https://ru.wikipedia.org/wiki/GitHub";


    @Test
    public void gitWikiLinkTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://.google.com");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        WebElement input = driver.findElement(By.cssSelector("input[title='Поиск']"));
        input.click();
        input.sendKeys("github");
        input.sendKeys(Keys.ENTER);

        WebElement wikiLink = driver.findElement(By.linkText("Википедия"));
        String wikiLinkString = wikiLink.getAttribute("href");

        assertEquals(WIKILINK, wikiLinkString);
        driver.quit();

    }
}
