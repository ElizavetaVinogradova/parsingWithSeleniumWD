import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Film {
    public static String parsingTitle(ChromeDriver driver, String tagName1, String tagName2){
        String title = driver.findElementById(tagName1).findElement(By.tagName(tagName2)).getText();
        if (title != null && !title.isEmpty()) {
            return title;
        }else {return "Не указано";}
    }

    public static String parsingDescription(ChromeDriver driver, String tagName1, String tagName2){
        String description = driver.findElementByClassName("product-review").findElement(By.xpath(".//p[@itemprop='description']")).getText();
        if (description != null && !description.isEmpty()) {
            return description;
        }else {return "Не указано";}
    }

    public static String parsingPrice(ChromeDriver driver, String tagName1, String tagName2){
        String price = driver.findElementById("left-stack").findElement(By.xpath(".//span[@itemprop='price']")).getText();
        if (price != null && !price.isEmpty()) {
            return price;
        }else {return "Не указано";}
    }

    private int id; //auto_increment
    private String filmUrl;
    private String title;
    private String description;
    private String price;

    public Film(ChromeDriver driver, String filmUrl) {
        this.filmUrl = filmUrl;
        this.title = parsingTitle(driver, "title", "span");
        this.description = parsingDescription(driver, "product-review", ".//p[@itemprop='description']");
        this.price = parsingPrice(driver, "left-stack", ".//span[@itemprop='price']");
    }

    public int getId() {return id;}
    public String getFilmUrl() {
        return filmUrl;
    }
    public void setFilmUrl(String filmUrl) {
        this.filmUrl = filmUrl;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getPrice() { return price; }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", filmUrl='" + filmUrl + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
