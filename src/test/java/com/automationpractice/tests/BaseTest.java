package com.automationpractice.tests;

import com.automationpractice.pageobjects.Footer;
import com.automationpractice.pageobjects.Header;
import com.automationpractice.utils.Utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    Footer footer;
    Header header;

    @BeforeClass
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(Utils.readProperty("timeoutDuration"))));
        driver.manage().window().maximize();
        driver.get(Utils.readProperty("url"));

        footer = new Footer(driver);
        header = new Header(driver);
    }

   // @AfterClass
    //public void tearDown() {
     //   driver.quit();
    //}

    /*
     * This method will run after each test,
     * it will take screenshot only for tests that failed
     */
    @AfterMethod
    public void failedTest(ITestResult result) {
        //check if the test failed
        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot)driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(srcFile, new File("./ScreenShots/"+result.getName()+".jpg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //result.getname() method will give you current test case name.
            //./ScreenShots/ tell you that, in your current directory, create folder ScreenShots. dot represents current directory
        }
    }
}
