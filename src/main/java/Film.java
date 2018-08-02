import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Film {
    public static String parsingTitle(ChromeDriver driver, String tagName1, String tagName2){
        String title = driver.findElementById(tagName1).findElement(By.tagName(tagName2)).getText();
        if (title != null && !title.isEmpty()) {
            return title;
        }else {return "Не указано";}
    }

    public static String parsingDescription(ChromeDriver driver, String tagName1, String tagName2){
        String description = driver.findElementByClassName(tagName1).findElement(By.xpath(tagName2)).getText();
        if (description != null && !description.isEmpty()) {
            return description;
        }else {return "Не указано";}
    }

    public static String parsingPrice(ChromeDriver driver, String tagName1, String tagName2){
        String price = driver.findElementById(tagName1).findElement(By.xpath(tagName2)).getText();
        if (price != null && !price.isEmpty()) {
            return price;
        }else {return "Не указано";}
    }

    public static String parsingEpisodesWithDescriptions(ChromeDriver driver){
        List<WebElement> episodesWithDescription = driver.findElementsByClassName("text");
        StringBuilder sb = new StringBuilder();
        episodesWithDescription.forEach(s -> sb.append(s.getText()).append("\n"));
        if (sb.length() != 0) {
            return sb.toString();
        }else {return "Не указано";}
    }

    private int id; //auto_increment
    private String filmUrl;
    private String title;
    private String description;
    private String price;
    private String episodesWithDescriptions;

    public Film(ChromeDriver driver, String filmUrl) {
        this.filmUrl = filmUrl;
        this.title = parsingTitle(driver, "title", "span");
        this.description = parsingDescription(driver, "product-review", ".//p[@itemprop='description']");
        this.price = parsingPrice(driver, "left-stack", ".//span[@itemprop='price']");
        this.episodesWithDescriptions = parsingEpisodesWithDescriptions(driver);
    }

    public int getId() {return id;}
    public String getFilmUrl() {
        return filmUrl;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getPrice() { return price; }
    public String getEpisodesWithDescriptions() { return episodesWithDescriptions; }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", filmUrl='" + filmUrl + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", episodesWithDescriptions='" + episodesWithDescriptions + '\'' +
                '}';
    }
}
