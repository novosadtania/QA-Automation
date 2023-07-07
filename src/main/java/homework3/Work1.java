package homework3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/* http://only-testing-blog.blogspot.com/2014/01/textbox.html?
Написать программу реализующую действие показанное на "видео1.mp4".
После выполнения программы на консоли должна выводится информация в следующем виде:

Автомобили доступные для выбора:
Volvo, BMW, Opel, Audi, Toyota, Renault, Maruti Car.
Страны из первой таблицы:
USA, Russia, Japan, Mexico, India, Malaysia, Greece.
Страны из второй таблицы:
France, Germany, Italy, Spain.*/
public class Work1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html?");
        WebElement car = driver.findElement(By.id("Carlist"));
        Select carList = new Select(car);
        carList.selectByValue("Renault Car");
        Thread.sleep(2000);
        System.out.print("Список машин : ");
        List<WebElement> carLists = carList.getOptions();
        for (WebElement cars : carLists) {
            System.out.print(cars.getText() + ", ");
        }

        WebElement countries = driver.findElement(By.xpath("//select[@name ='FromLB']"));
        Select countrie = new Select(countries);
        driver.findElement(By.id("check2")).click();
        driver.findElement(By.id("check1")).click();
        countrie.selectByVisibleText("France");
        Thread.sleep(1000);
        countrie.selectByValue("India");
        Thread.sleep(1000);
        countrie.deselectByValue("India");
        Thread.sleep(1000);
        countrie.selectByValue("Germany");
        Thread.sleep(1000);
        countrie.selectByValue("Italy");
        Thread.sleep(1000);
        countrie.selectByValue("Malaysia");
        Thread.sleep(1000);
        countrie.deselectByValue("Malaysia");
        Thread.sleep(1000);
        countrie.selectByValue("Spain");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@value ='->']")).click();
        Thread.sleep(2000);
        System.out.print("\b\b.\n Країни 1 таблиці : " );

        WebElement tabl1 = driver.findElement(By.xpath("//select[@name ='FromLB']"));
        Select tablytsia1 = new Select(tabl1);
        List<WebElement> tabli = tablytsia1.getOptions();
        for (WebElement countr : tabli) {
            System.out.print(countr.getText() + ", " );
        }

        System.out.print("\b\b.\n Країни 2 таблиці : ");
        WebElement tabl2 = driver.findElement(By.xpath("//select[@name ='ToLB']"));
        Select tablytsia2 = new Select(tabl2);
        List<WebElement> tabli2 = tablytsia2.getOptions();
        for (WebElement countr2 : tabli2) {
            System.out.print(countr2.getText() + ", ");
        }
        System.out.println("\b\b.");
        driver.quit();

    }
}

