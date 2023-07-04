package less4;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

/*Открыть в браузере три различные вкладки. На каждой вкладке открыть отдельно различные любые страницы,
вывести в консоль названия открытых страниц. Закрыть браузер.*/
public class Less4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://pethouse.ua/ua/account/login/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        Set<String> window0 = driver.getWindowHandles();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> window1 = driver.getWindowHandles();
        window1.removeAll(window0);
        String newWindow1 = window1.iterator().next();
        driver.switchTo().window(newWindow1);
        driver.get("https://dan-it.com.ua/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        ((JavascriptExecutor)driver).executeScript("window.open()");
        Set<String> window2 = driver.getWindowHandles();
        window2.removeAll(window1);
        String newWindow2 = window2.iterator().next();
        driver.switchTo().window(newWindow2);
        driver.get("https://www.jetbrains.com/idea/");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());
        driver.quit();


    }
}
