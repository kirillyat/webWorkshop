import models.*;
import services.*;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.Date;

public class SystemTest {
    String URL = "http://localhost:8080/";
    WebDriver driver;
    WebDriverWait wait;

    peopleService pService = new peopleService();
    marrigeService mService = new marrigeService();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    people human = new people("ИВАНОВ ИВАН",5,65, java.sql.Date.valueOf("2000-10-10"), null, "driver","moscow");
    marrige marriage = new marrige(50, 70, java.sql.Date.valueOf("2020-09-09"), java.sql.Date.valueOf("2040-09-09"));

    @BeforeClass
    public void settings() {
        final String safariDriverPath = "/usr/bin/safaridriver";
        System.setProperty("webdriver.safari.driver", safariDriverPath);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "eager");
        driver = new SafariDriver(capabilities);
        driver.manage().window().setSize(new Dimension(1000, 1000));
        driver.manage().timeouts().implicitlyWait(10, SECONDS);

        wait = new WebDriverWait(driver,10);
        driver.manage().timeouts().pageLoadTimeout(10, SECONDS);


    }

    @Test()
    public void checkHuman() {
        driver.get(URL);
        Assert.assertEquals(driver.getTitle(), "Main page");

        driver.findElement(By.id("peopleList_link")).click();
        Assert.assertEquals(driver.getTitle(), "People list");

        driver.findElement(By.id("humanAdd_button")).click();
        Assert.assertEquals(driver.getTitle(), "Add human");
        driver.findElement(By.id("name")).sendKeys(human.getName());
        driver.findElement(By.id("mother")).sendKeys(Integer.valueOf(human.getMother_id()).toString());
        driver.findElement(By.id("father")).sendKeys(Integer.valueOf(human.getFather_id()).toString());
        driver.findElement(By.id("address")).sendKeys(human.getAddress());
        driver.findElement(By.id("description")).sendKeys(human.getDescription());
        driver.findElement(By.id("birth_date")).sendKeys(human.getBirth_date().toString());
        driver.findElement(By.id("death_date")).sendKeys(human.getDeath_date().toString());

        driver.findElement(By.id("submit_button")).click();

        Assert.assertEquals(driver.getTitle(), "Human page");
        String infoText = driver.findElement(By.id("humanInfo_text")).getText();
        Assert.assertTrue(infoText.contains(human.getName()));
        Assert.assertTrue(infoText.contains(Integer.valueOf(human.getMother_id()).toString()));
        Assert.assertTrue(infoText.contains(Integer.valueOf(human.getFather_id()).toString()));
        Assert.assertTrue(infoText.contains(human.getAddress()));
        Assert.assertTrue(infoText.contains(human.getDescription()));
        Assert.assertTrue(infoText.contains(human.getBirth_date().toString()));
        Assert.assertTrue(infoText.contains(human.getDeath_date().toString()));

        driver.findElement(By.id("delete_button")).click();
        Assert.assertEquals(driver.getTitle(), "People list");
    }

    @Test()
    public void errorTest(){
        driver.get(URL+"/human?id=9944444499");
        Assert.assertEquals(driver.getTitle(), "Error");

        driver.get(URL+"/marriage?id=99435299");
        Assert.assertEquals(driver.getTitle(), "Error");
    }
  

    @Test()
    public void checkMarriage() {
        driver.get(URL);
        Assert.assertEquals(driver.getTitle(), "Main page");
        
        driver.findElement(By.id("marriagesList_link")).click();
        Assert.assertEquals(driver.getTitle(), "Marriages");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        driver.findElement(By.id("marriageAdd_button")).click();
        Assert.assertEquals(driver.getTitle(), "Add marriage");
        driver.findElement(By.id("wife_id")).sendKeys(Integer.valueOf(marriage.getWife_id()).toString());
        driver.findElement(By.id("husband_id")).sendKeys(Integer.valueOf(marriage.getHusband_id()).toString());
        driver.findElement(By.id("marriage_date")).sendKeys(marriage.getMarriage_date().toString());
        driver.findElement(By.id("divorce_date")).sendKeys(marriage.getDivorce_date().toString());

        driver.findElement(By.id("submit_button")).click();

        Assert.assertEquals(driver.getTitle(), "Marriage page");
        String infoText = driver.findElement(By.id("marriageInfo_text")).getText();
        Assert.assertTrue(infoText.contains(Integer.valueOf(marriage.getWife_id()).toString()));
        Assert.assertTrue(infoText.contains(Integer.valueOf(marriage.getHusband_id()).toString()));
        Assert.assertTrue(infoText.contains(df.format((marriage.getMarriage_date()))));
        Assert.assertTrue(infoText.contains(df.format((marriage.getMarriage_date()))));

        driver.findElement(By.id("delete_button")).click();
        Assert.assertEquals(driver.getTitle(), "Marriages");
    }




    
    @Test()
    public void checkADDMarriage() {
        driver.get(URL);
        Assert.assertEquals(driver.getTitle(), "Main page");

        driver.findElement(By.id("marriagesList_link")).click();
        Assert.assertEquals(driver.getTitle(), "Marriages");

        driver.findElement(By.id("marriageAdd_button")).click();
        Assert.assertEquals(driver.getTitle(), "Add marriage");
        driver.findElement(By.id("wife_id")).sendKeys(Integer.valueOf(marriage.getWife_id()).toString());
        driver.findElement(By.id("husband_id")).sendKeys(Integer.valueOf(marriage.getHusband_id()).toString());
        driver.findElement(By.id("marriage_date")).sendKeys(marriage.getMarriage_date().toString());
        driver.findElement(By.id("divorce_date")).sendKeys(marriage.getDivorce_date().toString());

        driver.findElement(By.id("submit_button")).click();


    }

    @Test()
    public void firstPageTest(){
        driver.get(URL);
        Assert.assertEquals(driver.getTitle(), "Main page");
    }

    @AfterClass
    public void clear() {
        driver.quit();
    }

}
