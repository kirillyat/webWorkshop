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

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SystemTest {
    String URL = "http://localhost:8080/";
    WebDriver driver;
    WebDriverWait wait;

    peopleService pService = new peopleService();
    marrigeService mService = new marrigeService();

    people human = new people();
    marrige marriage = new marrige();

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

    }

    @Test()
    public void errorTest(){
        driver.get(URL+"/human?id=9944444499");
        Assert.assertEquals(driver.getTitle(), "Error");

        driver.get(URL+"/marriage?id=99435299");
        Assert.assertEquals(driver.getTitle(), "Error");
    }
    @Test()
    public void error2Test(){
        driver.get(URL+"/human?id=9944444499");
        Assert.assertEquals(driver.getTitle(), "Error");

        driver.get(URL+"/marriage?id=99435299");
        Assert.assertEquals(driver.getTitle(), "Error");
    }

    @Test()
    public void error3Test(){
        driver.get(URL+"/human?id=9944444499");
        Assert.assertEquals(driver.getTitle(), "Error");

        driver.get(URL+"/marriage?id=99435299");
        Assert.assertEquals(driver.getTitle(), "Error");
    }

    @Test()
    public void error4Test(){
        driver.get(URL+"/human?id=9944444499");
        Assert.assertEquals(driver.getTitle(), "Error");

        driver.get(URL+"/marriage?id=99435299");
        Assert.assertEquals(driver.getTitle(), "Error");
    }


    @AfterClass
    public void clear() {
        driver.quit();
    }

}
