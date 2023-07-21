package from_S_less8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Test1 {
    static WebDriver driver;
    static Waiters waiters;

    @BeforeClass
    public void prepare(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        waiters = new Waiters(driver);
        driver.manage().window().maximize();
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        try {
            new Waiters(driver).waitForVisabilityOfWebElementReturn
                    (By.id("ez-accept-all")).click();
        } catch (Exception e) {
            System.out.println("Cookies not Found");
        }
    }


    @Test
    public void checkPageTitle() {
        driver.get("https://klopotenko.com/en/");
        try {
            new Waiters(driver).waitForVisabilityOfWebElementReturn
                    (By.xpath("//a[@aria-label ='dismiss cookie message']")).click();
        } catch (Exception e){
            System.out.println("Cookies not Found");
        }
        assertTrue(driver.getTitle().contains("Chef Ievgen Klopotenko"), "Название страницы не соответсвует ожидаемому");

        assertFalse(driver.getTitle().contains("Chef Ievgdssdvsdven Klopotenko"), "Название страницы соответсвует ожидаемому");
        String expectedText = "UKRAINIAN";
        String actualText = driver.findElement(By.xpath("//ul[@id = 'menu-main_menu-en-1']//a[text()='Ukrainian']")).getText();
        assertEquals(actualText, expectedText,
                "Я ожидал увидеть текст " + expectedText + ", а получил текст " + actualText);
        assertNotEquals(actualText, "UKRAINIAn");
    }

    @Test
    public void checkSearch(){
        driver.get("https://www.guinnessworldrecords.com/search");
        String searchValue = "handstand";
        waiters.waitForVisabilityOfWebElementReturn(By.id("search-term")).sendKeys(searchValue);
        driver.findElement(By.id("search-button")).click();
        WebElement resultSearch = waiters.waitForVisabilityOfWebElementReturn(By.tagName("h2"));
        assertTrue(resultSearch.getText().contains(searchValue));
    }

    @Test
    public void workingOfCheckBox(){
        driver.get("https://www.guinnessworldrecords.com/Account/Login");
        //RememberMe
        WebElement checkBox = waiters.waitForVisabilityOfWebElementReturn(By.id("RememberMe"));
        assertTrue(checkBox.isDisplayed());
        assertFalse(checkBox.isSelected());
        checkBox.click();
        assertTrue(checkBox.isSelected());
        checkBox.click();
        assertFalse(checkBox.isSelected());
    }
    @Test
    public void countOfElements(){
        driver.get("https://www.guinnessworldrecords.com/records/apply-to-set-or-break-a-record/");
        waiters.waitForVisabilityOfWebElement(By.xpath("//h5[text()='RECORDS']"));
        int countOfElementsActual = driver.findElements(By.xpath("//h5[text()='RECORDS']//following-sibling::ul//a")).size();
        int countOfElementsExpected = 12;
        assertEquals(countOfElementsActual, countOfElementsExpected);
    }


    @AfterClass
    public void closeDriver(){
        driver.quit();
    }


}
