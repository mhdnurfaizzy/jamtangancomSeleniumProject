package mhdnurfaizzy.testComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mhdnurfaizzy.Test.LoginTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import mhdnurfaizzy.pageobjects.LoginPage;

public class baseTesting {

    public WebDriver driver;
    public LoginPage loginPage;

    public WebDriver Inittialized() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/mhdnurfaizzy/resource/globalData.properties");
        prop.load(fis);
        String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
//		String browserName = prop.getProperty("browser");

        if(browserName.contains("edge")) {
            EdgeOptions Options = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
//			Options.addArguments("--headless=new");
            if(browserName.contains("headless")) {
                Options.addArguments("headless");
            }
            driver = new EdgeDriver(Options);
            driver.manage().window().setSize(new Dimension(1440,990)); //full screen

        } else if(browserName.equalsIgnoreCase("chrome"))
        {
            //ChromeDriver
            ChromeOptions Options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
//				driver = new ChromeDriver();
            driver = new ChromeDriver(Options);
            driver.manage().window().setSize(new Dimension(1440,990)); //full screen

        } else if(browserName.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }

    public static List<HashMap<String, String>> getDataJsonToMap(String filePath) throws IOException {
        //read JSON to String
        String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir") + "/src/main/java/mhdnurfaizzy/data/Purchase.json"), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    public String getScrenshoot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
    }



    @BeforeMethod(alwaysRun= true)
    public LoginPage launchApplication() throws IOException
    {
        driver = Inittialized();
        loginPage = new LoginPage(driver);
        loginPage.goTo();
        //uncomment this line, and put ur credential
        //loginPage.loginApplication("your_email", "your_password");
        return loginPage;

    }

    @AfterMethod(alwaysRun= true)
    public void endTest()
    {
        driver.quit();
    }



}
