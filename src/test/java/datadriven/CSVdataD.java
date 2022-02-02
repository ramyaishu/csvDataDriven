package datadriven;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

public class CSVdataD {

        WebDriver driver;
        String url= "https://www.saucedemo.com/";
        String filepath="/Users/vanchinathanac/IdeaProjects/csvDataDriven/src/main/resources/CSVTest/Data.csv";
 @BeforeClass
        public void openbroswer()
        {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        }
        @Test
        public void ReadData() throws IOException, CsvValidationException
        {
            driver.get(url);
            CSVReader reader =new CSVReader(new FileReader(filepath));
            String[]  cell;
            while((cell=reader.readNext())!=null)
            {
                for(int i=0;i<1;i++)
                {
                    String username=cell[i];
                    String password=cell[i+1];
                    driver.findElement(By.id("user-name")).sendKeys(username);
                    driver.findElement(By.id("password")).sendKeys(password);
                    driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();

                }
            }
        }
}
