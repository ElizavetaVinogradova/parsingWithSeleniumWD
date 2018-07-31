import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://itunes.apple.com/us/tv-season/all-the-way/id1110849356");
        System.out.println(chromeDriver.getTitle());
        System.out.println(chromeDriver.getCurrentUrl());
        chromeDriver.quit();

    }
}
