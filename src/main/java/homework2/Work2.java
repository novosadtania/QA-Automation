package homework2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*Написать метод в параметры которого принимаются два ВебЭлемента.
метод выводит в консоль информацию какой из двух элементов располагается  выше на странице,
какой из элементов располагается левее на странице,
а также какой из элементов занимает большую площадь.
Параметры метода могут также включать в себя другие аргументы, если это необходимо.
*/
public class Work2 {
    static void information(WebElement element1, WebElement element2) {
        int element1Y = element1.getLocation().y;
        int element2Y = element2.getLocation().y;
        if (element1Y > element2Y) {
            System.out.println("\"" + element2.getText() + "\"" + " знаходиться лівіше!");
        } else {
            System.out.println("\"" + element1.getText() + "\"" + " знаходиться лівіше!");
        }
        int element1height = element1.getSize().height;
        int element1width = element1.getSize().width;
        int element2height = element2.getSize().height;
        int element2width = element2.getSize().width;
        int element1S = element1height * element1width;
        int element2S = element2height * element2width;
        if (element1S > element2S) {
            System.out.println("Площа більша у кнопки : " + "\"" + element1.getText() + "\" !");
        } else if (element2S > element1S) {
            System.out.println("Площа більша у кнопки : " + "\"" + element2.getText() + "\" !");
        } else {
            System.out.println("Площі рівні!");
        }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AdminP\\Desktop\\Selen\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.get("https://pethouse.ua/ua/account/login/");
        WebElement dogs = driver.findElement(By.id("tpl-top-menu-first-li-1"));
        WebElement cats = driver.findElement(By.id("tpl-top-menu-first-li-2"));
        information(dogs, cats);
        driver.quit();

    }
}
